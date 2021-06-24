package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.Member;
import cn.gyw.community.system.dao.MemberMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends BaseService<Member> {

	@Autowired
    private MemberMapper memberMapper;
}
