package cn.gyw.community.inventory.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.inventory.product.dao.InventoryProductMapper;
import cn.gyw.community.inventory.product.entity.InventoryProduct;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class InventoryProductService extends BaseService<InventoryProduct> {

	@Autowired
	private InventoryProductMapper inventoryProductMapper;
}
