package cn.gyw.demo.seckill.inventory.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface WarehouseProductMapper extends BaseDao<WarehouseProduct, WarehouseProductExample> {
}