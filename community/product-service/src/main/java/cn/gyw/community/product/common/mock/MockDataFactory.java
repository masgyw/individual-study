package cn.gyw.community.product.common.mock;

import java.math.BigDecimal;

import javax.annotation.Nullable;

import org.apache.commons.lang3.RandomUtils;

import cn.gyw.community.inventory.api.dto.InventoryProductDto;

public abstract class MockDataFactory {

	public static InventoryProductDto mockWarehouseProduct(@Nullable Integer productId) {
		if (productId.equals(null)) {
			productId = RandomUtils.nextInt();
		}
		InventoryProductDto warehouseProduct = new InventoryProductDto();
		warehouseProduct.setProductId(productId);
		warehouseProduct.setwId(Short.valueOf(String.valueOf(RandomUtils.nextInt(1000, 9999))));
		warehouseProduct.setCurrentCnt(RandomUtils.nextInt(1000, 9999));
		warehouseProduct.setInTransitCnt(RandomUtils.nextInt());
		warehouseProduct.setAverageCost(BigDecimal.valueOf(RandomUtils.nextInt(100, 999)));
		return warehouseProduct;
	}
	
}
