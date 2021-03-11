package cn.gyw.community.product.pic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.mapper.product.ProductPicInfoMapper;
import cn.gyw.community.product.pic.model.ProductPicInfo;
import cn.gyw.community.product.pic.model.ProductPicInfoExample;
import cn.gyw.components.web.base.mgb.BaseService;

@Service
public class ProductPicInfoService extends BaseService<ProductPicInfo, ProductPicInfoExample> {

	@Autowired
	private ProductPicInfoMapper productPicInfoMapper;
}
