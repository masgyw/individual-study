package cn.gyw.demo.seckill.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.components.web.base.mgb.BaseController;
import cn.gyw.demo.seckill.order.api.OrderMasterService;
import cn.gyw.demo.seckill.order.api.model.OrderMaster;
import cn.gyw.demo.seckill.order.api.model.OrderMasterExample;
import cn.gyw.demo.seckill.order.model.dto.OrderMasterDto;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<OrderMaster, OrderMasterExample, OrderMasterDto> {

    @Autowired
    private OrderMasterService orderMasterService;

    @Override
    public OrderMasterExample buildExample(Map<String, String> requestMap) {
        OrderMasterExample example = new OrderMasterExample();
        example.createCriteria().andOrderIdEqualTo(Integer.parseInt(requestMap.get("orderId")));
        return example;
    }

}
