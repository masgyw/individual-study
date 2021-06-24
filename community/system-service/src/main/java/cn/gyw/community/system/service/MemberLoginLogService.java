package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberLoginLog;
import cn.gyw.community.system.dao.MemberLoginLogMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginLogService extends BaseService<MemberLoginLog> {

	@Autowired
    private MemberLoginLogMapper memberLoginLogMapper;
}
