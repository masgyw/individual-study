package cn.gyw.demo.seckill.inventory.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.gyw.demo.seckill.inventory.api.WarehouseProductService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;
import cn.gyw.demo.seckill.inventory.dao.WarehouseProductMapper;
import cn.gyw.demo.seckill.order.api.OrderMasterService;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Component
@Service
public class WarehouseProductServiceImpl extends BaseService<WarehouseProduct, WarehouseProductExample>
    implements WarehouseProductService {

    @Autowired
    private WarehouseProductMapper warehouseProductMapper;
    
//    @Reference
//    private ProductInfoService productInfoService;
    
    @Reference
    private OrderMasterService orderMasterService;

	@Override
	public void getProductByWarehousePraoduct(String productId) {
//		ProductInfoExample example = new ProductInfoExample();
//		example.createCriteria().andProductCoreEqualTo(productId);
//		ProductInfo product = productInfoService.query(example).get(0);
//		System.out.println(product);
//		productInfoService.buyProduct();
//		productInfoService.buyProductFor();
		orderMasterService.queryAll();
		System.out.println("success ...");
		
	}

	@Override
	public boolean decrease(String productInfo) {
		log.debug("product info is {}", productInfo);
		Gson gson = new Gson();
		JsonObject product = gson.fromJson(productInfo, JsonObject.class);
		int productId = product.get("productId").getAsInt();
		
		WarehouseProductExample example = new WarehouseProductExample();
		example.createCriteria().andProductIdEqualTo(productId);
		WarehouseProduct warehouseProduct = this.selectOne(example);
		if (Objects.isNull(warehouseProduct)) {
			log.debug("库存不存在");
			return false;
		}
		warehouseProduct.setCurrentCnt(warehouseProduct.getCurrentCnt() - 1);
		warehouseProductMapper.updateByExampleSelective(warehouseProduct, example);
		log.debug("减库存成功");
		
		return false;
	}
    
	// 冻结库存
    @Override
    public boolean tryDecrease(String productInfo) {
    	log.debug("product info is {}", productInfo);
		Gson gson = new Gson();
		JsonObject product = gson.fromJson(productInfo, JsonObject.class);
		int productId = product.get("productId").getAsInt();
		
		WarehouseProductExample example = new WarehouseProductExample();
		example.createCriteria().andProductIdEqualTo(productId);
		WarehouseProduct warehouseProduct = this.selectOne(example);
		if (Objects.isNull(warehouseProduct)) {
			log.debug("库存不存在");
			return false;
		}
		// 冻结库存 1个
		warehouseProduct.setLockCnt(1);
		warehouseProductMapper.updateByExampleSelective(warehouseProduct, example);
		log.debug("减库存成功");
		
		return false;
    }
}
