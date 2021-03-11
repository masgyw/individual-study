package cn.gyw.community.product.model.dto;

import java.io.Serializable;

import cn.gyw.community.product.model.ProductInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;

public class ProductWithWarehouseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductInfo productInfo;
	
	private WarehouseProduct warehouseProduct;

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public WarehouseProduct getWarehouseProduct() {
		return warehouseProduct;
	}

	public void setWarehouseProduct(WarehouseProduct warehouseProduct) {
		this.warehouseProduct = warehouseProduct;
	}
	
	
}
