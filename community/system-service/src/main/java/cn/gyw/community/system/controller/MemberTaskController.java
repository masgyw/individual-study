package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberTask;
import cn.gyw.community.system.dto.MemberTaskDto;
import cn.gyw.community.system.service.MemberTaskService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberTask")
public class MemberTaskController extends BaseController<MemberTask,MemberTaskDto> {

    @Autowired
    private MemberTaskService memberTaskService;
	
}
