package cn.gyw.community.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.system.dto.ApiLogDto;
import cn.gyw.community.system.entity.SysLog;
import cn.gyw.community.system.service.ISysLogService;
import cn.gyw.components.web.base.mybatisplus.BaseController;

@RestController
@RequestMapping("/log")
public class SysLogController extends BaseController<SysLog, ApiLogDto> {

    @Autowired
    private ISysLogService sysLogService;

    @Override
    protected Map<String, String> setOrderColumns() {
        Map<String, String> map = new HashMap<>();
        map.put("desc", SysLog.CREATED_TIME);
        return map;
    }
}
