package cn.gyw.community.order.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import cn.gyw.community.inventory.api.IInventoryProductApi;
import cn.gyw.community.order.api.OrderMasterService;
import cn.gyw.community.order.api.model.OrderMaster;
import cn.gyw.community.order.dao.OrderMasterMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Component
@Service
public class OrderMasterServiceImpl extends BaseService<OrderMaster> implements OrderMasterService {

	@Autowired
	private OrderMasterMapper orderMasterMapper;

	@Reference
	private IInventoryProductApi warehouseProductService;

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
