package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberProductCategoryRelation;
import cn.gyw.community.system.dao.MemberProductCategoryRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberProductCategoryRelationService extends BaseService<MemberProductCategoryRelation> {

	@Autowired
    private MemberProductCategoryRelationMapper memberProductCategoryRelationMapper;
}
