package cn.gyw.community.product.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.community.product.category.model.ProductCategoryExample;
import cn.gyw.community.product.mapper.product.ProductCategoryMapper;
import cn.gyw.components.web.base.mgb.BaseService;

@Service
public class ProductCategoryService extends BaseService<ProductCategory, ProductCategoryExample> {

	@Autowired
	private ProductCategoryMapper productCategoryMapper;
}
