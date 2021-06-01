package cn.gyw.community.product.info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.info.model.Product;
import cn.gyw.community.product.info.service.ProductInfoServiceImpl;
import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.community.product.model.dto.ProductDto;
import cn.gyw.platform.common.web.base.mgb.BaseController;

/**
 * Product service
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController<ProductInfo, ProductDto> {

	@Autowired
	private ProductInfoServiceImpl productInfoService;
	
//	@Get
//	public List<Product> getProductWithPic() {
//		
//	}

	/**
	 * 热销商品列表
	 * 
	 * @return
	 */
	@PostMapping("/hot")
	public List<Product> getHotProduct(@RequestBody Map<String, Object> reqObject) {
		log.info("params is {}", reqObject);
		log.info("{}", reqObject.get("categoryName").getClass());
		List<String> reqObj = (List<String>) reqObject.get("categoryName");
		List<Product> productList = new ArrayList<>();
		reqObj.forEach(cate -> {
			productList.addAll(productInfoService.getProductPics(cate));
		});
		return productList;
	}

	/**
	 * 促销商品列表
	 * 
	 * @return
	 */
	@PostMapping("/promo")
	public List<Product> getPromoProduct(@RequestBody Map<String, String> reqObject) {
		log.info("params is {}", reqObject);
		String categoryName = reqObject.get("categoryName");
		return productInfoService.getProductPics(categoryName);
	}
}
