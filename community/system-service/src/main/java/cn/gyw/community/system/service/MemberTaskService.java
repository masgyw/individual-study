package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberTask;
import cn.gyw.community.system.dao.MemberTaskMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberTaskService extends BaseService<MemberTask> {

	@Autowired
    private MemberTaskMapper memberTaskMapper;
}
