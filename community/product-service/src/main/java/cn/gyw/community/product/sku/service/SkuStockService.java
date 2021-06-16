package cn.gyw.community.product.sku.service;

import cn.gyw.community.product.sku.dao.SkuStockMapper;
import cn.gyw.community.product.sku.entity.SkuStock;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuStockService extends BaseService<SkuStock> {
    @Autowired
    private SkuStockMapper skuStockMapper;
}
