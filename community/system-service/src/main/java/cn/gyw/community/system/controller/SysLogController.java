package cn.gyw.community.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.system.dto.ApiLogDto;
import cn.gyw.community.system.entity.SysLog;
import cn.gyw.community.system.service.ISysLogService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/log")
public class SysLogController extends BaseController<SysLog, ApiLogDto> {

    @Autowired
    private ISysLogService sysLogService;

}
