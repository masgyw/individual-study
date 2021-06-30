package cn.gyw.community.product.dao;

import cn.gyw.community.product.entity.ProductCategory;
import cn.gyw.community.product.entity.ProductCategoryWithChildren;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

import java.util.List;

public interface ProductCategoryMapper extends BaseDao<ProductCategory> {

    List<ProductCategoryWithChildren> listWithChildren();
}