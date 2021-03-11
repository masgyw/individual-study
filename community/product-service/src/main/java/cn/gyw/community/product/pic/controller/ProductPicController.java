package cn.gyw.community.product.pic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.pic.model.ProductPicInfo;
import cn.gyw.community.product.pic.model.ProductPicInfoDto;
import cn.gyw.community.product.pic.model.ProductPicInfoExample;
import cn.gyw.community.product.pic.service.ProductPicInfoService;
import cn.gyw.components.web.base.mgb.BaseController;

@RestController
@RequestMapping("/pic")
public class ProductPicController extends BaseController<ProductPicInfo, ProductPicInfoExample, ProductPicInfoDto> {

	@Autowired
	private ProductPicInfoService productPicInfoService;
	
}
