package cn.gyw.community.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.dao.ProductPicInfoMapper;
import cn.gyw.community.product.entity.ProductPicInfo;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import tk.mybatis.mapper.entity.Example;

@Service
public class ProductPicInfoService extends BaseService<ProductPicInfo> {

	@Autowired
	private ProductPicInfoMapper productPicInfoMapper;
	
	public List<ProductPicInfo> queryAllCarousel() {
		Example example = new Example(ProductPicInfo.class);
		ProductPicInfo picInfo = new ProductPicInfo();
		picInfo.setIsMaster((byte) 1);
		picInfo.setPicStatus((byte) 1);
		example.createCriteria().andEqualTo(picInfo);
		return productPicInfoMapper.selectByExample(example);
	}
}
