package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.RoleResourceRelation;
import cn.gyw.community.system.dao.RoleResourceRelationMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleResourceRelationService extends BaseService<RoleResourceRelation> {

	@Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
}
