package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.RolePermissionRelation;
import cn.gyw.community.system.dao.RolePermissionRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionRelationService extends BaseService<RolePermissionRelation> {

	@Autowired
    private RolePermissionRelationMapper rolePermissionRelationMapper;
}
