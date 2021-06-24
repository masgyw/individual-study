package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.Role;
import cn.gyw.community.system.dao.RoleMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role> {

	@Autowired
    private RoleMapper roleMapper;
}
