package cn.gyw.community.product.brand.service;

import cn.gyw.community.product.brand.dao.BrandMapper;
import cn.gyw.community.product.brand.entity.Brand;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<Brand> {

    @Autowired
    private BrandMapper brandMapper;
}
