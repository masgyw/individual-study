package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberMemberTagRelation;
import cn.gyw.community.system.dto.MemberMemberTagRelationDto;
import cn.gyw.community.system.service.MemberMemberTagRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberMemberTagRelation")
public class MemberMemberTagRelationController extends BaseController<MemberMemberTagRelation,MemberMemberTagRelationDto> {

    @Autowired
    private MemberMemberTagRelationService memberMemberTagRelationService;
	
}
