package cn.gyw.community.product.mapper.warehouse;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.components.web.base.mgb.BaseDao;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProduct;
import cn.gyw.demo.seckill.inventory.api.model.WarehouseProductExample;

@Mapper
public interface WarehouseMapper extends BaseDao<WarehouseProduct, WarehouseProductExample> {
}