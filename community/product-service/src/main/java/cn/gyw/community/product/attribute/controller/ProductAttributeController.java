package cn.gyw.community.product.attribute.controller;

import cn.gyw.community.product.attribute.dto.ProductAttributeDto;
import cn.gyw.community.product.attribute.entity.ProductAttribute;
import cn.gyw.community.product.attribute.service.ProductAttributeService;
import cn.gyw.platform.common.web.base.mgb.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attr")
public class ProductAttributeController extends BaseController<ProductAttribute, ProductAttributeDto> {
    @Autowired
    private ProductAttributeService productAttributeService;

}
