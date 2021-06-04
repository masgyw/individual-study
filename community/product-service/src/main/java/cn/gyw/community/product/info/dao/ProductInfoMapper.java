package cn.gyw.community.product.info.dao;

import java.util.List;

import cn.gyw.community.product.info.dto.ProductInfoDto;
import cn.gyw.community.product.info.entity.ProductInfo;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

public interface ProductInfoMapper extends BaseDao<ProductInfo> {
	
	public List<ProductInfoDto> selectWithPic(String category);
	
}