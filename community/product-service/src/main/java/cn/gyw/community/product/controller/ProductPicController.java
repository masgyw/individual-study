package cn.gyw.community.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.entity.ProductPicInfo;
import cn.gyw.community.product.dto.ProductPicInfoDto;
import cn.gyw.community.product.service.ProductPicInfoService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/pic")
public class ProductPicController extends BaseController<ProductPicInfo, ProductPicInfoDto> {

	@Autowired
	private ProductPicInfoService productPicInfoService;

	@GetMapping("/carousel")
	public List<ProductPicInfoDto> getCarousel() {
		List<ProductPicInfo> datas = productPicInfoService.queryAllCarousel();
		List<ProductPicInfoDto> result = new ArrayList<>(datas.size());
		datas.forEach((info) -> {
			ProductPicInfoDto carousel = new ProductPicInfoDto();
			BeanUtils.copyProperties(info, carousel);
			result.add(carousel);
		});
		return result;
	}
}
