package cn.gyw.demo.seckill.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.demo.seckill.inventory.api.WarehouseInfoService;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfoExample;
import cn.gyw.demo.seckill.inventory.dao.WarehouseInfoMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service
public class WarehouseInfoServiceImpl extends BaseService<WarehouseInfo, WarehouseInfoExample>
        implements WarehouseInfoService {

    @Autowired
    private WarehouseInfoMapper warehouseInfoMapper;
}
