package cn.gyw.community.product.service;
//package cn.gyw.community.product.rpc.service;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.gson.Gson;
//
//import cn.gyw.community.inventory.api.WarehouseProductService;
//import cn.gyw.community.inventory.api.model.WarehouseProduct;
//import cn.gyw.community.inventory.api.model.WarehouseProductExample;
//import cn.gyw.community.order.api.OrderMasterService;
//import cn.gyw.community.product.mapper.product.ProductInfoMapper;
//import cn.gyw.community.product.mapper.warehouse.WarehouseMapper;
//import cn.gyw.community.product.mock.MockDataFactory;
//import cn.gyw.community.product.model.ProductInfo;
//import cn.gyw.community.product.model.ProductInfoExample;
//import cn.gyw.community.product.model.dto.ProductDto;
//import cn.gyw.community.product.model.dto.ProductWithWarehouseDto;
//import cn.gyw.platform.common.web.base.mgb.BaseService;
//
//@Service
//@Profile(value = "rpc")
//public class ProductInfoRpcServiceImpl extends BaseService<ProductInfo> implements ProductInfoRpcService {
//
//	@Autowired
//	private ProductInfoMapper productInfoMapper;
//	
//	@Autowired
//	private RedisTemplate<String, Serializable> redisTemplate;
//	
//	private static final String KEY_PREFIX = "PRODUCTINFO:";
//
//	@Reference
//	private WarehouseProductService warehouseProductService;
//	
//	@Reference
//	private OrderMasterService orderMasterService;
//	
//	@Autowired
//	private WarehouseMapper warehouseMapper;
//
//	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
//	@Override
//	public void addWithInventory(ProductInfo productInfo) {
//		// ?????????
//		warehouseProductService.save(MockDataFactory.mockWarehouseProduct(productInfo.getProductId()));
//		// ????????????
//		save(productInfo);
//		// ??????????????????????????????????????????????????????
////		throw new RuntimeException();
//	}
//
//	@Override
//	public int deleteProduct(String productCore) {
//		String key = KEY_PREFIX + productCore;
//		boolean isDeleted = redisTemplate.delete(key);
//		if (isDeleted) {
//			ProductInfoExample example = new ProductInfoExample();
//			example.createCriteria().andProductCoreEqualTo(productCore);
//			int result = productInfoMapper.deleteByExample(example);
//			log.info("remove result :{}", result);
//			return result;
//		} else {
//			return -1;
//		}
//	}
//
//	@Override
//	public ProductWithWarehouseDto queryWithInventory(String productCore) {
//		String key = KEY_PREFIX + productCore;
//		// cache aside pattern
//		ProductWithWarehouseDto productDto  = (ProductWithWarehouseDto) redisTemplate.opsForValue().get(key);
//		if (productDto == null) {
//			productDto = new ProductWithWarehouseDto();
//			ProductInfoExample example = new ProductInfoExample();
//			example.createCriteria().andProductCoreEqualTo(productCore);
//			List<ProductInfo> datas = productInfoMapper.selectByExample(example);
//			if (datas.size() == 0) {
//				return productDto;
//			}
//			productDto.setProductInfo(datas.get(0));
//			// ??????????????????
//			WarehouseProductExample wpExample = new WarehouseProductExample();
//			wpExample.createCriteria().andProductIdEqualTo(Integer.parseInt(productCore));
//			List<WarehouseProduct> wpList = new ArrayList<>();
//			if (wpList.size() != 0) {
//				productDto.setWarehouseProduct(wpList.get(0));
//			}
//			redisTemplate.opsForValue().set(key, productDto);
//		}
//		return productDto;
//	}
//
//	@Override
//	public boolean buyProduct(ProductDto productDto) {
//		// ????????????
//		boolean result = orderMasterService.createOrder(new Gson().toJson(productDto));
//		log.debug("result :{}", result);
//		return result;
//	}
//
//	/**
//	 * ?????????????????????1???XA ????????????
//	 * ?????????????????????????????????????????????????????????????????????
//	 */
//	@Transactional(transactionManager = "jtaTransactionManager")
//	@Override
//	public boolean buyProductWithXA(ProductDto productDto) {
//		log.debug("productInfoMapper is :{}", this.productInfoMapper);
//		log.debug("inventoryMapper is :{}", this.warehouseMapper);
//		// 1 ????????????
//		ProductInfo productInfo = new ProductInfo();
//		BeanUtils.copyProperties(productDto, productInfo);
//		this.productInfoMapper.insertSelective(productInfo);
//		// 2 ????????????
//		WarehouseProduct warehouseProduct = MockDataFactory.mockWarehouseProduct(productInfo.getProductId());
//		this.warehouseMapper.insertSelective(warehouseProduct);
//		
//		// mock exception to rollback
////		int i = 1/ 0;
//		
//		return true;
//	}
//	
//	/**
//	 * ?????????????????????2???TCC try-commit-cancel ?????????????????????????????????
//	 * ???????????????????????????????????????????????????
//	 * ??????????????????????????????
//	 */
//	@Override
//	public String buyProductWithTCC(ProductDto productDto) {
//		Gson gson = new Gson();
//		Map<String, Object> tmpMap = new HashMap<>();
//		// ????????????
//		ProductInfoExample example = createExample(productDto);
//		ProductInfo productInfo = new ProductInfo();
//		ProductInfo newProductInfo = new ProductInfo();
//		newProductInfo.setPrice(productInfo.getPrice().subtract(new BigDecimal(1)));
//		this.productInfoMapper.updateByExample(productInfo, example);
//		
//		// ???????????? RPC ????????????
//		// ?????????????????????????????????????????????????????????????????????????????? UPDATING??????????????????????????????
//		orderMasterService.tryCreateOrder(gson.toJson(productInfo));
//		
//		// ???????????? RPC ????????????
//		// ?????????????????????????????????????????????
//		WarehouseProduct warehouseProduct = MockDataFactory.mockWarehouseProduct(productInfo.getProductId());
//		warehouseProductService.decrease(gson.toJson(warehouseProduct));
//		
//		return gson.toJson(tmpMap);
//	}
//	
//	private ProductInfoExample createExample(ProductDto productDto) {
//		ProductInfoExample example = new ProductInfoExample();
//		ProductInfoExample.Criteria criteria = example.createCriteria();
//		
//		criteria.andProductCoreEqualTo(productDto.getProductCore());
//		
//		return example;
//	}
//
//}
