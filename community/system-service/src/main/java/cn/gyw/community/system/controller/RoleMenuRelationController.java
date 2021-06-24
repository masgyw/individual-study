package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.RoleMenuRelation;
import cn.gyw.community.system.dto.RoleMenuRelationDto;
import cn.gyw.community.system.service.RoleMenuRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/roleMenuRelation")
public class RoleMenuRelationController extends BaseController<RoleMenuRelation,RoleMenuRelationDto> {

    @Autowired
    private RoleMenuRelationService roleMenuRelationService;
	
}
