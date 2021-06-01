package cn.gyw.community.inventory.api;

import java.util.List;

import cn.gyw.community.inventory.api.model.WarehouseProduct;

public interface WarehouseProductService {
	
	List<WarehouseProduct> queryAll();
	
	int save(WarehouseProduct record);
	
	void getProductByWarehousePraoduct(String productId);
	
	boolean decrease(String productInfo);
	
	boolean tryDecrease(String productInfo);
}
