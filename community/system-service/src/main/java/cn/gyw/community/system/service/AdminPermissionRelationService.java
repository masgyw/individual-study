package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.AdminPermissionRelation;
import cn.gyw.community.system.dao.AdminPermissionRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPermissionRelationService extends BaseService<AdminPermissionRelation> {

	@Autowired
    private AdminPermissionRelationMapper adminPermissionRelationMapper;
}
