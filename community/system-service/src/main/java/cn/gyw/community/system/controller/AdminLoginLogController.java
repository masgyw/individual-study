package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.AdminLoginLog;
import cn.gyw.community.system.dto.AdminLoginLogDto;
import cn.gyw.community.system.service.AdminLoginLogService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/adminLoginLog")
public class AdminLoginLogController extends BaseController<AdminLoginLog,AdminLoginLogDto> {

    @Autowired
    private AdminLoginLogService adminLoginLogService;
	
}
