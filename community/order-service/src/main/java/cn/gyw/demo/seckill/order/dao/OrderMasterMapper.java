package cn.gyw.demo.seckill.order.dao;

import cn.gyw.components.web.base.mgb.BaseDao;
import cn.gyw.demo.seckill.order.api.model.OrderMaster;
import cn.gyw.demo.seckill.order.api.model.OrderMasterExample;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMasterMapper extends BaseDao<OrderMaster, OrderMasterExample> {
}