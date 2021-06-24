package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Role;
import cn.gyw.community.system.dto.RoleDto;
import cn.gyw.community.system.service.RoleService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role,RoleDto> {

    @Autowired
    private RoleService roleService;
	
}
