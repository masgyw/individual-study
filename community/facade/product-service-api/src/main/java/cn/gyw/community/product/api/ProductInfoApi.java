package cn.gyw.community.product.api;

import java.util.List;

import cn.gyw.community.product.dto.ProductDto;

public interface ProductInfoApi {
	
	List<ProductDto> queryAll();
	
	int save(ProductDto record);

}
