package cn.gyw.demo.seckill.inventory.service.impl;

import cn.gyw.components.web.base.mgb.BaseService;
import cn.gyw.demo.seckill.inventory.api.WarehouseInfoService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfoExample;
import cn.gyw.demo.seckill.inventory.dao.WarehouseInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseInfoServiceImpl extends BaseService<WarehouseInfo, WarehouseInfoExample>
        implements WarehouseInfoService {

    @Autowired
    private WarehouseInfoMapper warehouseInfoMapper;
}
