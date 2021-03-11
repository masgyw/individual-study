package cn.gyw.demo.seckill.order.api;

import java.util.List;

import cn.gyw.demo.seckill.order.api.model.OrderMaster;
import cn.gyw.demo.seckill.order.api.model.OrderMasterExample;

public interface OrderMasterService {
	
	List<OrderMaster> queryAll();
	
	List<OrderMaster> query(OrderMasterExample example);
	
	int remove(OrderMasterExample example);
	
	int save(OrderMaster record);
	
	boolean createOrder(String productInfo);
	
	boolean tryCreateOrder(String productInfo);
}
