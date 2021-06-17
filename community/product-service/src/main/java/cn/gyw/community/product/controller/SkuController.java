package cn.gyw.community.product.controller;

import cn.gyw.community.product.dto.SkuStockDto;
import cn.gyw.community.product.entity.SkuStock;
import cn.gyw.community.product.service.SkuStockService;
import cn.gyw.platform.common.web.base.mgb.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
public class SkuController  extends BaseController<SkuStock, SkuStockDto> {
    @Autowired
    private SkuStockService skuStockService;
}
