package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberTag;
import cn.gyw.community.system.dao.MemberTagMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberTagService extends BaseService<MemberTag> {

	@Autowired
    private MemberTagMapper memberTagMapper;
}
