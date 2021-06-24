package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberLoginLog;
import cn.gyw.community.system.dto.MemberLoginLogDto;
import cn.gyw.community.system.service.MemberLoginLogService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberLoginLog")
public class MemberLoginLogController extends BaseController<MemberLoginLog,MemberLoginLogDto> {

    @Autowired
    private MemberLoginLogService memberLoginLogService;
	
}
