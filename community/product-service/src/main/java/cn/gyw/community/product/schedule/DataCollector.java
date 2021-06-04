package cn.gyw.community.product.schedule;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.gyw.community.product.info.entity.ProductInfo;
import cn.gyw.community.product.info.service.ProductInfoService;

@Component
public class DataCollector {

	@Autowired
	private ProductInfoService productInfoService;
	
	
//	@Scheduled(fixedRate = 1000 * 60 * 10)
	public void cellectProductDatas() {
		List<Product> datas = SoupUtils.soupTmallByKeyWord("手机");
		for (int i = 0, len = datas.size(); i < len; i++) {
			Product product = datas.get(i);
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProductCore(product.getNumber().toString());
			productInfo.setProductName(product.getTitle());
			productInfo.setPrice(new BigDecimal(product.getPrice()));
			// dummy data
			productInfo.setBarCode("100000010");
			productInfo.setBrandId(10);
			productInfo.setAverageCost(new BigDecimal(product.getPrice()));
			productInfo.setProductionDate(new Date());
			productInfo.setDescript(product.getTitle());
			this.productInfoService.save(productInfo);
		}
	}
}
