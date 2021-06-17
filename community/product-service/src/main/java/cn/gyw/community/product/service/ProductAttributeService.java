package cn.gyw.community.product.service;

import cn.gyw.community.product.dao.ProductAttributeMapper;
import cn.gyw.community.product.entity.ProductAttribute;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeService extends BaseService<ProductAttribute> {
    @Autowired
    private ProductAttributeMapper productAttributeMapper;
}
