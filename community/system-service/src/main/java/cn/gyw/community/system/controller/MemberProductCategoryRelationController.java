package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberProductCategoryRelation;
import cn.gyw.community.system.dto.MemberProductCategoryRelationDto;
import cn.gyw.community.system.service.MemberProductCategoryRelationService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberProductCategoryRelation")
public class MemberProductCategoryRelationController extends BaseController<MemberProductCategoryRelation,MemberProductCategoryRelationDto> {

    @Autowired
    private MemberProductCategoryRelationService memberProductCategoryRelationService;
	
}
