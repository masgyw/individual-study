package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberLevel;
import cn.gyw.community.system.dto.MemberLevelDto;
import cn.gyw.community.system.service.MemberLevelService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberLevel")
public class MemberLevelController extends BaseController<MemberLevel,MemberLevelDto> {

    @Autowired
    private MemberLevelService memberLevelService;
	
}
