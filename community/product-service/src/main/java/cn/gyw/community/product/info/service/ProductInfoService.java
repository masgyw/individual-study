package cn.gyw.community.product.info.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.category.dao.ProductCategoryMapper;
import cn.gyw.community.product.category.entity.ProductCategory;
import cn.gyw.community.product.dto.ProductDto;
import cn.gyw.community.product.info.dao.ProductInfoMapper;
import cn.gyw.community.product.info.entity.ProductInfo;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import tk.mybatis.mapper.entity.Example;

@Service
public class ProductInfoService extends BaseService<ProductInfo> {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
    public List<ProductInfo> getProductPics(String categoryName) {
        // TODO get data from db
		/*
		 * List<String> list = new ArrayList<>(); if (categoryName.equals("手机")) {
		 * list.add("/phone/Redmi-k30.png"); } if (categoryName.equals("")) {
		 * 
		 * }else { list.add("/appliance/AirCondition-F3W1.png"); }
		 */
        Example example = new Example(ProductCategory.class);
        example.createCriteria().andEqualTo("categoryName", categoryName);
        ProductCategory category = productCategoryMapper.selectOneByExample(example);
        if (Objects.isNull(category)) {
        	log.info("Category {} is not exists!", categoryName);
        	return Collections.emptyList();
        }
        example = new Example(ProductDto.class);
//        example.createCriteria().andOneCategoryIdEqualTo(Short.valueOf(category.getCategoryCode()));
        List<ProductInfo> datas = new ArrayList<>();
//        		productInfoMapper.selectWithPicByExample(example);
        return datas;
    }

}
