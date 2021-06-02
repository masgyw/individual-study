package cn.gyw.community.product.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.category.dao.ProductCategoryMapper;
import cn.gyw.community.product.category.entity.ProductCategory;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class ProductCategoryService extends BaseService<ProductCategory> {

	@Autowired
	private ProductCategoryMapper productCategoryMapper;
}
