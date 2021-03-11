package cn.gyw.demo.seckill.inventory.api;

import java.util.List;

import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;

public interface WarehouseProductService {
	
	List<WarehouseProduct> queryAll();
	
	List<WarehouseProduct> query(WarehouseProductExample example);
	
	int remove(WarehouseProductExample example);
	
	int save(WarehouseProduct record);
	
	void getProductByWarehousePraoduct(String productId);
	
	boolean decrease(String productInfo);
	
	boolean tryDecrease(String productInfo);
}
