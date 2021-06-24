package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.RoleResourceRelation;
import cn.gyw.community.system.dto.RoleResourceRelationDto;
import cn.gyw.community.system.service.RoleResourceRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/roleResourceRelation")
public class RoleResourceRelationController extends BaseController<RoleResourceRelation,RoleResourceRelationDto> {

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;
	
}
