package cn.gyw.community.product.sku.controller;

import cn.gyw.community.product.sku.dto.SkuStockDto;
import cn.gyw.community.product.sku.entity.SkuStock;
import cn.gyw.community.product.sku.service.SkuStockService;
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
