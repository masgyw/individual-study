package cn.gyw.community.product.rpc.service;

import cn.gyw.community.product.mapper.product.ProductInfoMapper;
import cn.gyw.community.product.mapper.warehouse.WarehouseMapper;
import cn.gyw.community.product.mock.MockDataFactory;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.ProductInfoExample;
import cn.gyw.community.product.model.dto.ProductDto;
import cn.gyw.community.product.model.dto.ProductWithWarehouseDto;
import cn.gyw.components.web.base.mgb.BaseService;
import cn.gyw.demo.seckill.inventory.api.WarehouseProductService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;
import cn.gyw.demo.seckill.order.api.OrderMasterService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Profile(value = "rpc")
public class ProductInfoRpcServiceImpl extends BaseService<ProductInfo, ProductInfoExample> implements ProductInfoRpcService {

	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;
	
	private static final String KEY_PREFIX = "PRODUCTINFO:";

	@Reference
	private WarehouseProductService warehouseProductService;
	
	@Reference
	private OrderMasterService orderMasterService;
	
	@Autowired
	private WarehouseMapper warehouseMapper;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public void addWithInventory(ProductInfo productInfo) {
		// 加库存
		warehouseProductService.save(MockDataFactory.mockWarehouseProduct(productInfo.getProductId()));
		// 添加产品
		save(productInfo);
		// 问题：库存成功，产品回滚，数据不一致
//		throw new RuntimeException();
	}

	@Override
	public int deleteProduct(String productCore) {
		String key = KEY_PREFIX + productCore;
		boolean isDeleted = redisTemplate.delete(key);
		if (isDeleted) {
			ProductInfoExample example = new ProductInfoExample();
			example.createCriteria().andProductCoreEqualTo(productCore);
			int result = productInfoMapper.deleteByExample(example);
			log.info("remove result :{}", result);
			return result;
		} else {
			return -1;
		}
	}

	@Override
	public ProductWithWarehouseDto queryWithInventory(String productCore) {
		String key = KEY_PREFIX + productCore;
		// cache aside pattern
		ProductWithWarehouseDto productDto  = (ProductWithWarehouseDto) redisTemplate.opsForValue().get(key);
		if (productDto == null) {
			productDto = new ProductWithWarehouseDto();
			ProductInfoExample example = new ProductInfoExample();
			example.createCriteria().andProductCoreEqualTo(productCore);
			List<ProductInfo> datas = productInfoMapper.selectByExample(example);
			if (datas.size() == 0) {
				return productDto;
			}
			productDto.setProductInfo(datas.get(0));
			// 查询库存信息
			WarehouseProductExample wpExample = new WarehouseProductExample();
			wpExample.createCriteria().andProductIdEqualTo(Integer.parseInt(productCore));
			List<WarehouseProduct> wpList = warehouseProductService.query(wpExample);
			if (wpList.size() != 0) {
				productDto.setWarehouseProduct(wpList.get(0));
			}
			redisTemplate.opsForValue().set(key, productDto);
		}
		return productDto;
	}

	@Override
	public boolean buyProduct(ProductDto productDto) {
		// 创建订单
		boolean result = orderMasterService.createOrder(new Gson().toJson(productDto));
		log.debug("result :{}", result);
		return result;
	}

	/**
	 * 分布式解决方案1：XA ，两提交
	 * 缺点：单个服务，访问多个库，违反微服务架构设计
	 */
	@Transactional(transactionManager = "jtaTransactionManager")
	@Override
	public boolean buyProductWithXA(ProductDto productDto) {
		log.debug("productInfoMapper is :{}", this.productInfoMapper);
		log.debug("inventoryMapper is :{}", this.warehouseMapper);
		// 1 新增产品
		ProductInfo productInfo = new ProductInfo();
		BeanUtils.copyProperties(productDto, productInfo);
		this.productInfoMapper.insertSelective(productInfo);
		// 2 新增库存
		WarehouseProduct warehouseProduct = MockDataFactory.mockWarehouseProduct(productInfo.getProductId());
		this.warehouseMapper.insertSelective(warehouseProduct);
		
		// mock exception to rollback
//		int i = 1/ 0;
		
		return true;
	}
	
	/**
	 * 分布式解决方案2：TCC try-commit-cancel 业务层面上的两阶段提交
	 * 优点：强一致性，用于现金支付类场景
	 * 缺点：与业务高度耦合
	 */
	@Override
	public String buyProductWithTCC(ProductDto productDto) {
		Gson gson = new Gson();
		Map<String, Object> tmpMap = new HashMap<>();
		// 修改产品
		ProductInfoExample example = createExample(productDto);
		ProductInfo productInfo = this.selectOne(example);
		ProductInfo newProductInfo = new ProductInfo();
		newProductInfo.setPrice(productInfo.getPrice().subtract(new BigDecimal(1)));
		this.productInfoMapper.updateByExample(productInfo, example);
		
		// 生成订单 RPC 远程调用
		// 别直接把订单状态修改为已支付啊！你先把订单状态修改为 UPDATING，也就是修改中的意思
		orderMasterService.tryCreateOrder(gson.toJson(productInfo));
		
		// 新增库存 RPC 远程调用
		// 别直接扣减库存，而是冻结掉库存
		WarehouseProduct warehouseProduct = MockDataFactory.mockWarehouseProduct(productInfo.getProductId());
		warehouseProductService.decrease(gson.toJson(warehouseProduct));
		
		return gson.toJson(tmpMap);
	}
	
	private ProductInfoExample createExample(ProductDto productDto) {
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		
		criteria.andProductCoreEqualTo(productDto.getProductCore());
		
		return example;
	}
}
