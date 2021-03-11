package cn.gyw.demo.seckill.inventory.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.components.web.base.mgb.BaseController;
import cn.gyw.demo.seckill.inventory.api.WarehouseProductService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;
import cn.gyw.demo.seckill.inventory.model.dto.WarehouseProductDto;

@RestController
@RequestMapping("/warehouse-product")
public class WarehouseProductController
        extends BaseController<WarehouseProduct, WarehouseProductExample, WarehouseProductDto> {

    @Autowired
    private WarehouseProductService warehouseProductService;
    
    @GetMapping("/product/{productId}")
    public int getProduct(@PathVariable String productId) {
    	warehouseProductService.getProductByWarehousePraoduct(productId);
    	return 1;
    }

    @Override
    public WarehouseProductExample buildExample(Map<String, String> requestMap) {
        WarehouseProductExample example = new WarehouseProductExample();
        example.createCriteria().andWpIdEqualTo(Integer.parseInt(requestMap.get("wpId")));
        return example;
    }

}
