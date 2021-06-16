package cn.gyw.community.product.attribute.service;

import cn.gyw.community.product.attribute.dao.ProductAttributeMapper;
import cn.gyw.community.product.attribute.entity.ProductAttribute;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeService extends BaseService<ProductAttribute> {
    @Autowired
    private ProductAttributeMapper productAttributeMapper;
}
