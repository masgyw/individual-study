package cn.gyw.community.product.api;

import java.util.List;

import cn.gyw.community.product.model.ProductInfo;

public interface ProductInfoService {
	
	List<ProductInfo> queryAll();
	
	int save(ProductInfo record);

}
