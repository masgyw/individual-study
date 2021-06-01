package cn.gyw.community.order.api;

import java.util.List;

import cn.gyw.community.order.api.model.OrderMaster;

public interface OrderMasterService {
	
	List<OrderMaster> queryAll();
	
	boolean createOrder(String productInfo);
	
	boolean tryCreateOrder(String productInfo);
}
