package cn.gyw.demo.seckill.inventory.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.demo.seckill.inventory.api.WarehouseInfoService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfoExample;
import cn.gyw.demo.seckill.inventory.model.dto.WarehouseInfoDto;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/warehouse-info")
public class WarehouseInfoController extends BaseController<WarehouseInfo, WarehouseInfoExample, WarehouseInfoDto> {

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Override
    public WarehouseInfoExample buildExample(Map<String, String> requestMap) {
        WarehouseInfoExample example = new WarehouseInfoExample();
        example.createCriteria().andWIdEqualTo(Short.parseShort(requestMap.get("wid")));
        return example;
    }

}
