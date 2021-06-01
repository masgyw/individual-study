package cn.gyw.community.product.mapper.warehouse;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.inventory.api.model.WarehouseProduct;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface WarehouseMapper extends BaseDao<WarehouseProduct> {
}