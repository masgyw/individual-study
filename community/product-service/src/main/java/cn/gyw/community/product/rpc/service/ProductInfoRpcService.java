package cn.gyw.community.product.rpc.service;

import cn.gyw.community.product.api.ProductInfoService;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.dto.ProductDto;
import cn.gyw.community.product.model.dto.ProductWithWarehouseDto;

public interface ProductInfoRpcService extends ProductInfoService {

	void addWithInventory(ProductInfo productInfo);
	
	int deleteProduct(String productCore);
	
	ProductWithWarehouseDto queryWithInventory(String productCore);
	
	boolean buyProduct(ProductDto productDto);
	
	boolean buyProductWithXA(ProductDto productDto);
	
	String buyProductWithTCC(ProductDto productDto);
}
