package cn.gyw.demo.seckill.order.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import cn.gyw.components.web.base.mgb.BaseService;
import cn.gyw.demo.seckill.inventory.api.WarehouseProductService;
import cn.gyw.demo.seckill.order.api.OrderMasterService;
import cn.gyw.demo.seckill.order.api.model.OrderMaster;
import cn.gyw.demo.seckill.order.api.model.OrderMasterExample;
import cn.gyw.demo.seckill.order.dao.OrderMasterMapper;

@Component
@Service
public class OrderMasterServiceImpl extends BaseService<OrderMaster, OrderMasterExample> implements OrderMasterService {

	@Autowired
	private OrderMasterMapper orderMasterMapper;

	@Reference
	private WarehouseProductService warehouseProductService;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

	@Override
	public boolean createOrder(String productInfo) {

		// 1. 生成订单
		// 订单id 生成策略：时间戳
		String orderId = dtf.format(LocalDateTime.now());
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderSn(Long.valueOf(orderId));
		orderMaster.setCustomerId(RandomUtils.nextInt(1000, 9999));
		orderMaster.setShippingUser("LiSi-" + RandomUtils.nextInt(100, 999));
		orderMasterMapper.insertSelective(orderMaster);
		return true;
	}

	// 尝试创建订单
	@Override
	public boolean tryCreateOrder(String productInfo) {
		// 订单id 生成策略：时间戳
		String orderId = dtf.format(LocalDateTime.now());
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderSn(Long.valueOf(orderId));
		orderMaster.setCustomerId(RandomUtils.nextInt(1000, 9999));
		orderMaster.setShippingUser("LiSi-" + RandomUtils.nextInt(100, 999));
		// 将订单状态 更改为 更新中
		orderMaster.setOrderStatus(Byte.valueOf("1"));
		orderMasterMapper.insertSelective(orderMaster);
		return true;
	}
}
