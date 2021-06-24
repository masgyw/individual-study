package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.Permission;
import cn.gyw.community.system.dao.PermissionMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends BaseService<Permission> {

	@Autowired
    private PermissionMapper permissionMapper;
}
