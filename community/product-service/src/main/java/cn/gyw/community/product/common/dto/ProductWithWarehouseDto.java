package cn.gyw.community.product.common.dto;

import java.io.Serializable;

import cn.gyw.community.inventory.api.dto.InventoryProductDto;
import cn.gyw.community.product.dto.ProductDto;

public class ProductWithWarehouseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductDto productInfo;
	
	private InventoryProductDto inventoryProduct;

	public ProductDto getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductDto productInfo) {
		this.productInfo = productInfo;
	}

	public InventoryProductDto getInventoryProduct() {
		return inventoryProduct;
	}

	public void setInventoryProduct(InventoryProductDto inventoryProduct) {
		this.inventoryProduct = inventoryProduct;
	}
}
