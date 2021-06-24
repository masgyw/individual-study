package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberMemberTagRelation;
import cn.gyw.community.system.dao.MemberMemberTagRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberMemberTagRelationService extends BaseService<MemberMemberTagRelation> {

	@Autowired
    private MemberMemberTagRelationMapper memberMemberTagRelationMapper;
}
