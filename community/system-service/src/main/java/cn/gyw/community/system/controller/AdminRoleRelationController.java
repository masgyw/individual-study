package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.AdminRoleRelation;
import cn.gyw.community.system.dto.AdminRoleRelationDto;
import cn.gyw.community.system.service.AdminRoleRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/adminRoleRelation")
public class AdminRoleRelationController extends BaseController<AdminRoleRelation,AdminRoleRelationDto> {

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;
	
}
