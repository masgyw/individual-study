package cn.gyw.community.product.mock;

import java.math.BigDecimal;

import javax.annotation.Nullable;

import org.apache.commons.lang3.RandomUtils;

import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;

public abstract class MockDataFactory {

	public static WarehouseProduct mockWarehouseProduct(@Nullable Integer productId) {
		if (productId.equals(null)) {
			productId = RandomUtils.nextInt();
		}
		WarehouseProduct warehouseProduct = new WarehouseProduct();
		warehouseProduct.setProductId(productId);
		warehouseProduct.setwId(Short.valueOf(String.valueOf(RandomUtils.nextInt(1000, 9999))));
		warehouseProduct.setCurrentCnt(RandomUtils.nextInt(1000, 9999));
		warehouseProduct.setInTransitCnt(RandomUtils.nextInt());
		warehouseProduct.setAverageCost(BigDecimal.valueOf(RandomUtils.nextInt(100, 999)));
		return warehouseProduct;
	}
}
