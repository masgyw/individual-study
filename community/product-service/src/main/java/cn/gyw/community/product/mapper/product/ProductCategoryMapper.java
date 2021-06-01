package cn.gyw.community.product.mapper.product;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface ProductCategoryMapper extends BaseDao<ProductCategory> {

}
