package cn.gyw.community.product.brand.controller;

import cn.gyw.community.product.brand.dto.BrandDto;
import cn.gyw.community.product.brand.entity.Brand;
import cn.gyw.community.product.brand.service.BrandService;
import cn.gyw.platform.common.web.base.mgb.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController<Brand, BrandDto> {

    @Autowired
    private BrandService brandService;

}
