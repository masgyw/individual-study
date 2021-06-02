package cn.gyw.community.inventory.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.inventory.api.dto.InventoryProductDto;
import cn.gyw.community.inventory.product.entity.InventoryProduct;
import cn.gyw.community.inventory.product.service.InventoryProductService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/inventory/product")
public class InventoryProductController extends BaseController<InventoryProduct, InventoryProductDto> {

	@Autowired
	private InventoryProductService inventoryProductService;
}
