package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberReceiveAddress;
import cn.gyw.community.system.dto.MemberReceiveAddressDto;
import cn.gyw.community.system.service.MemberReceiveAddressService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberReceiveAddress")
public class MemberReceiveAddressController extends BaseController<MemberReceiveAddress,MemberReceiveAddressDto> {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;
	
}
