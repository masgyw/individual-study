package cn.gyw.community.product.category.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.community.product.category.model.ProductCategoryDto;
import cn.gyw.community.product.category.model.ProductCategoryExample;
import cn.gyw.community.product.category.service.ProductCategoryService;
import cn.gyw.components.web.base.mgb.BaseController;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<ProductCategory, ProductCategoryExample, ProductCategoryDto>  {

	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public ProductCategoryExample buildExample(Map<String, String> requestMap) {
		ProductCategoryExample example = new ProductCategoryExample();
		ProductCategoryExample.Criteria criteria = example.createCriteria();
		if (requestMap.containsKey("categoryId")) {
			criteria.andCategoryIdEqualTo(Integer.parseInt(requestMap.get("categoryId")));
		}
		return example;
	}
}
