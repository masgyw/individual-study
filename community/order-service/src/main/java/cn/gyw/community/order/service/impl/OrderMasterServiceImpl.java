package cn.gyw.community.order.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cn.gyw.community.order.dao.OrderMapper;
import cn.gyw.community.order.entity.Order;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import cn.gyw.community.inventory.api.IInventoryProductApi;
import cn.gyw.community.order.api.OrderMasterService;
import cn.gyw.community.order.api.model.OrderMaster;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Component
@Service
public class OrderMasterServiceImpl extends BaseService<OrderMaster> implements OrderMasterService {

	@Autowired
	private OrderMapper orderMapper;

	@Reference
	private IInventoryProductApi warehouseProductService;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

	@Override
	public boolean createOrder(String productInfo) {

		// 1. 生成订单
		// 订单id 生成策略：时间戳
		String orderId = dtf.format(LocalDateTime.now());
		Order orderMaster = new Order();
		orderMapper.insertSelective(orderMaster);
		return true;
	}

	// 尝试创建订单
	@Override
	public boolean tryCreateOrder(String productInfo) {
		// 订单id 生成策略：时间戳
		String orderId = dtf.format(LocalDateTime.now());
		Order orderMaster = new Order();
		orderMapper.insertSelective(orderMaster);
		return true;
	}
}
