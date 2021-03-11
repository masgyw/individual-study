package cn.gyw.community.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.product.model.Carousel;

/**
 * 轮播图资源
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {

	@GetMapping("")
	public List<Carousel> findInfo() {
		// TODO: select from db
		List<Carousel> list = new ArrayList<>();
		Carousel carousel = new Carousel();
		carousel.setCarouselId(1);
		carousel.setImgPath("/cms_1.jpg");
		carousel.setDescribes("desc1");
		list.add(carousel);
		carousel = new Carousel();
		carousel.setCarouselId(2);
		carousel.setImgPath("/cms_2.jpg");
		carousel.setDescribes("desc2");
		list.add(carousel);
		return list;
	}
}
