package cn.gyw.demo.seckill.inventory.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfo;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseInfoExample;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface WarehouseInfoMapper extends BaseDao<WarehouseInfo, WarehouseInfoExample> {
}