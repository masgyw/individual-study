package cn.gyw.community.product.service;

import cn.gyw.community.product.entity.ProductAttrCate;
import cn.gyw.community.product.dao.ProductAttrCateMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttrCateService extends BaseService<ProductAttrCate> {

	@Autowired
    private ProductAttrCateMapper productAttrCateMapper;
}
