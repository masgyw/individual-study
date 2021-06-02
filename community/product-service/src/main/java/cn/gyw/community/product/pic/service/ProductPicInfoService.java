package cn.gyw.community.product.pic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.pic.dao.ProductPicInfoMapper;
import cn.gyw.community.product.pic.model.ProductPicInfo;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class ProductPicInfoService extends BaseService<ProductPicInfo> {

	@Autowired
	private ProductPicInfoMapper productPicInfoMapper;
}
