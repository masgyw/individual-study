package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.RolePermissionRelation;
import cn.gyw.community.system.dto.RolePermissionRelationDto;
import cn.gyw.community.system.service.RolePermissionRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/rolePermissionRelation")
public class RolePermissionRelationController extends BaseController<RolePermissionRelation,RolePermissionRelationDto> {

    @Autowired
    private RolePermissionRelationService rolePermissionRelationService;
	
}
