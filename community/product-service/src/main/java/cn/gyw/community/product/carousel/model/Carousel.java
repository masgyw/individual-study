package cn.gyw.community.product.carousel.model;

import java.io.Serializable;

public class Carousel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer carouselId;

	private String imgPath;

	private String describes;

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getCarouselId() {
		return carouselId;
	}

	public void setCarouselId(Integer carouselId) {
		this.carouselId = carouselId;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	@Override
	public String toString() {
		return "Carousel{" +
				"imgPath='" + imgPath + '\'' +
				", describes='" + describes + '\'' +
				'}';
	}
}
