package cn.gyw.community.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.system.dto.RoleDto;
import cn.gyw.community.system.entity.SysRole;
import cn.gyw.community.system.service.ISysRoleService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

/**
 * <p>
 *  角色控制器
 * </p>
 *
 * @author guanyw
 * @since 2020-03-05
 */
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController<SysRole, RoleDto> {

    @Autowired
    private ISysRoleService sysRoleService;

}
