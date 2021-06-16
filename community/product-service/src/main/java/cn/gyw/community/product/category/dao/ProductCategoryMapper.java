package cn.gyw.community.product.category.dao;

import cn.gyw.community.product.category.entity.ProductCategory;
import cn.gyw.community.product.category.entity.ProductCategoryWithChildren;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

import java.util.List;

public interface ProductCategoryMapper extends BaseDao<ProductCategory> {

    List<ProductCategoryWithChildren> listWithChildren();
}