package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Member;
import cn.gyw.community.system.dto.MemberDto;
import cn.gyw.community.system.service.MemberService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/member")
public class MemberController extends BaseController<Member,MemberDto> {

    @Autowired
    private MemberService memberService;
	
}
