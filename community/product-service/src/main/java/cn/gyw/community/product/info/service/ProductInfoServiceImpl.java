package cn.gyw.community.product.info.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.community.product.category.model.ProductCategoryExample;
import cn.gyw.community.product.info.model.Product;
import cn.gyw.community.product.mapper.product.ProductCategoryMapper;
import cn.gyw.community.product.mapper.product.ProductInfoMapper;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.ProductInfoExample;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import tk.mybatis.mapper.entity.Example;

@Service
public class ProductInfoServiceImpl extends BaseService<ProductInfo>
        implements LocalProductInfoService {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
    @Override
    public List<Product> getProductPics(String categoryName) {
        // TODO get data from db
		/*
		 * List<String> list = new ArrayList<>(); if (categoryName.equals("手机")) {
		 * list.add("/phone/Redmi-k30.png"); } if (categoryName.equals("")) {
		 * 
		 * }else { list.add("/appliance/AirCondition-F3W1.png"); }
		 */
        Example example = new Example(ProductCategory.class);
        example.createCriteria().andEqualTo("category_name", categoryName);
        ProductCategory category = productCategoryMapper.selectOneByExample(example);
        if (Objects.isNull(category)) {
        	log.info("Category {} is not exists!", categoryName);
        	return Collections.emptyList();
        }
        example = new Example(ProductInfo.class);
//        example.createCriteria().andOneCategoryIdEqualTo(Short.valueOf(category.getCategoryCode()));
        List<Product> datas = new ArrayList<>();
//        		productInfoMapper.selectWithPicByExample(example);
        return datas;
    }

}
