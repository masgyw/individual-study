package cn.gyw.demo.seckill.inventory.dao;

import cn.gyw.components.web.base.mgb.BaseDao;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfoExample;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarehouseInfoMapper extends BaseDao<WarehouseInfo, WarehouseInfoExample> {
}