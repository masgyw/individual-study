package cn.gyw.community.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.dto.ProductInfoDto;
import cn.gyw.community.product.model.ProductInfoRequest;
import cn.gyw.community.product.entity.ProductInfo;
import cn.gyw.community.product.service.ProductInfoService;
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
	public List<ProductInfoDto> getHotProduct(@RequestBody ProductInfoRequest piRequest) {
		List<String> categoryNames = piRequest.getCategoryNameList();
		return productInfoService.getProductWithPics(categoryNames);
	}

	/**
	 * 促销商品列表
	 * 
	 * @return
	 */
	@PostMapping(path = "/promo")
	public List<ProductInfoDto> getPromoProduct(@RequestBody ProductInfoRequest piRequest) {
		List<String> categoryNames = piRequest.getCategoryNameList();
		return productInfoService.getProductWithPics(categoryNames);
	}
}
