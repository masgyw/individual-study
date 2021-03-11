package cn.gyw.community.product.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.product.info.model.Product;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.ProductInfoExample;
import cn.gyw.components.web.base.mgb.BaseDao;

@Mapper
public interface ProductInfoMapper extends BaseDao<ProductInfo, ProductInfoExample> {
	/**
	 * 查询包含图片的商品信息
	 * @param example
	 * @return
	 */
	List<Product> selectWithPicByExample(ProductInfoExample example);
	
}