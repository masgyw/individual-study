package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberTag;
import cn.gyw.community.system.dto.MemberTagDto;
import cn.gyw.community.system.service.MemberTagService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberTag")
public class MemberTagController extends BaseController<MemberTag,MemberTagDto> {

    @Autowired
    private MemberTagService memberTagService;
	
}
