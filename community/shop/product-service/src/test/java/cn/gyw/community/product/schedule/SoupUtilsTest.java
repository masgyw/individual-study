package cn.gyw.community.product.schedule;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class SoupUtilsTest {

	@Test
	public void testSoupTmallDetailById() {
		Product product = SoupUtils.soupTmallDetailById(632919105307L);
		System.out.println(product);
	}

	@Test
	public void testSoupTaobaoDetailById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSoupTmallByKeyWord() {
		List<Product> datas = SoupUtils.soupTmallByKeyWord("手机");
		datas.forEach((data) -> {
			System.out.println(data);
		});
	}

}
