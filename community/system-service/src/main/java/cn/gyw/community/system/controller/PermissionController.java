package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Permission;
import cn.gyw.community.system.dto.PermissionDto;
import cn.gyw.community.system.service.PermissionService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<Permission,PermissionDto> {

    @Autowired
    private PermissionService permissionService;
	
}
