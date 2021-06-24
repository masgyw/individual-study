package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.AdminLoginLog;
import cn.gyw.community.system.dao.AdminLoginLogMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginLogService extends BaseService<AdminLoginLog> {

	@Autowired
    private AdminLoginLogMapper adminLoginLogMapper;
}
