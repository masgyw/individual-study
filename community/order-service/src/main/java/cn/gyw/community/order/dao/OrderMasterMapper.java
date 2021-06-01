package cn.gyw.community.order.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.gyw.community.order.api.model.OrderMaster;
import cn.gyw.platform.common.web.base.mgb.BaseDao;

@Mapper
public interface OrderMasterMapper extends BaseDao<OrderMaster> {
}