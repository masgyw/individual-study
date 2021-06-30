package cn.gyw.community.product.service;

import cn.gyw.community.product.dao.BrandMapper;
import cn.gyw.community.product.entity.Brand;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<Brand> {

    @Autowired
    private BrandMapper brandMapper;
}
