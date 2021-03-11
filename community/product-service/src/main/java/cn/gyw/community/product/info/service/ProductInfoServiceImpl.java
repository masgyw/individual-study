package cn.gyw.community.product.info.service;

import cn.gyw.community.product.api.ProductInfoService;
import cn.gyw.community.product.category.model.ProductCategory;
import cn.gyw.community.product.category.model.ProductCategoryExample;
import cn.gyw.community.product.info.model.Product;
import cn.gyw.community.product.mapper.product.ProductCategoryMapper;
import cn.gyw.community.product.mapper.product.ProductInfoMapper;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.ProductInfoExample;
import cn.gyw.components.web.base.mgb.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ProductInfoServiceImpl extends BaseService<ProductInfo, ProductInfoExample>
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
        ProductCategoryExample pce = new ProductCategoryExample();
        pce.createCriteria().andCategoryNameEqualTo(categoryName);
        ProductCategory category = productCategoryMapper.selectOne(pce);
        if (Objects.isNull(category)) {
        	log.info("Category {} is not exists!", categoryName);
        	return Collections.emptyList();
        }
        ProductInfoExample example = new ProductInfoExample();
        example.createCriteria().andOneCategoryIdEqualTo(Short.valueOf(category.getCategoryCode()));
        List<Product> datas = productInfoMapper.selectWithPicByExample(example);
        return datas;
    }
}
