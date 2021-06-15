package cn.gyw.community.product.schedule;

import cn.gyw.community.product.info.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCollector {

	@Autowired
	private ProductInfoService productInfoService;

}
