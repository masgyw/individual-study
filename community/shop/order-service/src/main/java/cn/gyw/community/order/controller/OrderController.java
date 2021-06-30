package cn.gyw.community.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.order.api.OrderMasterService;
import cn.gyw.community.order.api.model.OrderMaster;
import cn.gyw.community.order.model.dto.OrderMasterDto;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<OrderMaster, OrderMasterDto> {

    @Autowired
    private OrderMasterService orderMasterService;

}
