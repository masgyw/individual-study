package cn.gyw.community.product.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.community.product.category.model.ProductCategoryDto;
import cn.gyw.community.product.category.service.ProductCategoryService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<ProductCategory, ProductCategoryDto>  {

	@Autowired
	private ProductCategoryService productCategoryService;

}
