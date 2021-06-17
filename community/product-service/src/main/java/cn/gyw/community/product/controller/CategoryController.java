package cn.gyw.community.product.controller;

import cn.gyw.community.product.entity.ProductCategoryWithChildren;
import cn.gyw.platform.common.web.model.PageData;
import cn.gyw.platform.common.web.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.gyw.community.product.dto.ProductCategoryDto;
import cn.gyw.community.product.entity.ProductCategory;
import cn.gyw.community.product.service.ProductCategoryService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<ProductCategory, ProductCategoryDto>  {

	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping("/parentId/{parentId}")
	public PageData<ProductCategory> getListByParentId(@PathVariable Long parentId,
													   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
													   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setParentId(parentId);
		List<ProductCategory> dataList = productCategoryService.query(productCategory, pageNum, pageSize);
		return PageHelperUtil.resetPage(dataList);
	}

	@GetMapping("/children")
	public List<ProductCategoryWithChildren> listWithChildren() {
		return productCategoryService.listWithChildren();
	}
}
