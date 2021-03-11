package cn.gyw.demo.seckill.inventory.dao;

import cn.gyw.components.web.base.mgb.BaseDao;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarehouseProductMapper extends BaseDao<WarehouseProduct, WarehouseProductExample> {
}