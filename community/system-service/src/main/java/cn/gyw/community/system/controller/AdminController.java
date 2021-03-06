package cn.gyw.community.system.controller;

import cn.gyw.community.system.dto.AdminRoleRelationDto;
import cn.gyw.community.system.dto.UserLoginParam;
import cn.gyw.community.system.entity.Role;
import cn.gyw.community.system.enums.SystemRespEnum;
import cn.gyw.community.system.service.RoleService;
import cn.gyw.platform.common.web.enums.CommonRespEnum;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;
import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gyw.community.system.entity.Admin;
import cn.gyw.community.system.dto.AdminDto;
import cn.gyw.community.system.service.AdminService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户管理
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin,AdminDto> {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    /**
     * 用户注册
     * @param adminDto
     * @return
     */
    @PostMapping(value = "/register")
    public BaseResponse register(@Validated @RequestBody AdminDto adminDto) {
        Admin umsAdmin = adminService.register(adminDto);
        if (umsAdmin == null) {
            return BaseResponse.error(SystemRespEnum.REGISTER_FAILED);
        }
        return DataResponse.success(umsAdmin);
    }

    @PostMapping(value = "/login")
    public BaseResponse login(@Validated @RequestBody UserLoginParam userLoginParam) {
        String token = adminService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        SystemRespEnum.LOGIN_FAILED.assertNotNull(token);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return DataResponse.success(tokenMap);
    }

    @GetMapping("/info")
    public BaseResponse getInfo(Principal principal) {
        CommonRespEnum.UN_AUTHORIZED.assertNotNull(principal);
        String username = principal.getName();
        Admin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<Role> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return DataResponse.success(data);
    }

    @PostMapping("/logout")
    public BaseResponse logout() {
        return BaseResponse.success();
    }

    /**
     * 分配角色
     */
    @PostMapping(value = "/allocRole")
    public BaseResponse allocRole(@RequestBody AdminRoleRelationDto adminRoleRelationDto) {
        log.info("/allocRole request :{}", adminRoleRelationDto);
        int count = adminService.updateRole(adminRoleRelationDto.getId(), adminRoleRelationDto.getRoleIds());
        if (count >= 0) {
            return DataResponse.success(count);
        }
        return BaseResponse.error(SystemRespEnum.ALLOC_ROLE_FAILED);
    }
}
