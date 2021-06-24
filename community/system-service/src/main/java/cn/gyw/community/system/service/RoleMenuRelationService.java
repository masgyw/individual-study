package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.RoleMenuRelation;
import cn.gyw.community.system.dao.RoleMenuRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuRelationService extends BaseService<RoleMenuRelation> {

	@Autowired
    private RoleMenuRelationMapper roleMenuRelationMapper;
}
