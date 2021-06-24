package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.AdminPermissionRelation;
import cn.gyw.community.system.dto.AdminPermissionRelationDto;
import cn.gyw.community.system.service.AdminPermissionRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/adminPermissionRelation")
public class AdminPermissionRelationController extends BaseController<AdminPermissionRelation,AdminPermissionRelationDto> {

    @Autowired
    private AdminPermissionRelationService adminPermissionRelationService;
	
}
