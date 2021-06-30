package cn.gyw.community.product.service;

import cn.gyw.community.product.api.ProductInfoApi;
import cn.gyw.community.product.common.dto.ProductDto;
import cn.gyw.community.product.common.dto.ProductWithWarehouseDto;

public interface ProductInfoRpcService extends ProductInfoApi {

	void addWithInventory(ProductDto productInfo);
	
	int deleteProduct(String productCore);
	
	ProductWithWarehouseDto queryWithInventory(String productCore);
	
	boolean buyProduct(ProductDto productDto);
	
	boolean buyProductWithXA(ProductDto productDto);
	
	String buyProductWithTCC(ProductDto productDto);
}
