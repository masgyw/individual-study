package cn.gyw.platform.common.web.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {

	@Test
	public void map2Bean() {
		Map<String, String> map = new HashMap<>();
		map.put("productAttributeCategoryId", "0");
		map.put("type", "1");

		OneBean bean = new OneBean();

		BeanUtils.copyProperties(map, bean);

		System.out.println(bean);
	}

	class OneBean {

		private Long productAttributeCategoryId;
		private Integer type;

		public Long getProductAttributeCategoryId() {
			return productAttributeCategoryId;
		}

		public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
			this.productAttributeCategoryId = productAttributeCategoryId;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "OneBean [productAttributeCategoryId=" + productAttributeCategoryId + ", type=" + type + "]";
		}

	}
}
