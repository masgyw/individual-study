package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.AdminRoleRelation;
import cn.gyw.community.system.dao.AdminRoleRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleRelationService extends BaseService<AdminRoleRelation> {

	@Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;
}
