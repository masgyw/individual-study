package cn.gyw.community.product.api;

import java.util.List;

import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.ProductInfoExample;

public interface ProductInfoService {
	
	List<ProductInfo> queryAll();
	
	List<ProductInfo> query(ProductInfoExample example);
	
	int remove(ProductInfoExample example);
	
	int save(ProductInfo record);

}
