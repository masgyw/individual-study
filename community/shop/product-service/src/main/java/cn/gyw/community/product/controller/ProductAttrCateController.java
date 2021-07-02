package cn.gyw.community.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.product.entity.ProductAttrCate;
import cn.gyw.community.product.dto.ProductAttrCateDto;
import cn.gyw.community.product.service.ProductAttrCateService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/attrCate")
public class ProductAttrCateController extends BaseController<ProductAttrCate,ProductAttrCateDto> {

    @Autowired
    private ProductAttrCateService productAttrCateService;
	
}
