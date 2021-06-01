package cn.gyw.community.system.service.impl;

import org.springframework.stereotype.Service;

import cn.gyw.community.system.entity.SysLog;
import cn.gyw.community.system.service.ISysLogService;
import cn.gyw.platform.common.web.base.mgb.BaseService;

@Service(value = "sysLogService")
public class SysLogServiceImpl extends BaseService<SysLog> implements ISysLogService {
}
