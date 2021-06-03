package cn.gyw.community.product.info.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.info.dto.ProductInfoDto;
import cn.gyw.community.product.info.dto.ProductInfoRequest;
import cn.gyw.community.product.info.entity.ProductInfo;
import cn.gyw.community.product.info.service.ProductInfoService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

/**
 * Product service
 */
@RestController
@RequestMapping("/info")
public class ProductInfoController extends BaseController<ProductInfo, ProductInfoDto> {

	@Autowired
	private ProductInfoService productInfoService;
	
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
	public List<ProductInfo> getHotProduct(@RequestBody ProductInfoRequest request) {
		
		log.info("params is {}", request);
		List<String> categoryList = request.getCategoryNameList();
		List<ProductInfo> productList = new ArrayList<>();
		categoryList.forEach(cate -> {
			productList.addAll(productInfoService.getProductPics(cate));
		});
		return productList;
	}

	/**
	 * 促销商品列表
	 * 
	 * @return
	 */
	@PostMapping(path = "/promo")
	public List<ProductInfo> getPromoProduct(@RequestBody ProductInfoRequest request) {
		log.info("params is {}", request);
		List<String> categoryList = request.getCategoryNameList();
		return productInfoService.getProductPics(categoryList.get(0));
	}
}
