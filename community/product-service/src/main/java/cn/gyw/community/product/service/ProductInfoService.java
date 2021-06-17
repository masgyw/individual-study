package cn.gyw.community.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.dao.ProductCategoryMapper;
import cn.gyw.community.product.entity.ProductCategory;
import cn.gyw.community.product.dao.ProductInfoMapper;
import cn.gyw.community.product.dto.ProductInfoDto;
import cn.gyw.community.product.entity.ProductInfo;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import tk.mybatis.mapper.entity.Example;

@Service
public class ProductInfoService extends BaseService<ProductInfo> {

	@Autowired
	private ProductInfoMapper productInfoMapper;

	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	public List<ProductInfoDto> getProductWithPics(List<String> categoryNames) {
		// TODO get data from db
		/*
		 * List<String> list = new ArrayList<>(); if (categoryName.equals("手机")) {
		 * list.add("/phone/Redmi-k30.png"); } if (categoryName.equals("")) {
		 * 
		 * }else { list.add("/appliance/AirCondition-F3W1.png"); }
		 */
		Example example = new Example(ProductCategory.class);
		example.createCriteria().andIn("categoryName", categoryNames);
		List<ProductCategory> categorys = productCategoryMapper.selectByExample(example);
		if (Objects.isNull(categorys)) {
			log.info("Category {} is not exists!", Arrays.toString(categoryNames.toArray()));
			return Collections.emptyList();
		}
		List<ProductInfoDto> result = new ArrayList<>();
		// categorys.forEach((pc) -> {
		// 	productInfoMapper.selectWithPic(pc.getCategoryName());
		// });
		return result;
	}

}
