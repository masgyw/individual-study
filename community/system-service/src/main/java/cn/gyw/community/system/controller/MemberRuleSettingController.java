package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberRuleSetting;
import cn.gyw.community.system.dto.MemberRuleSettingDto;
import cn.gyw.community.system.service.MemberRuleSettingService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberRuleSetting")
public class MemberRuleSettingController extends BaseController<MemberRuleSetting,MemberRuleSettingDto> {

    @Autowired
    private MemberRuleSettingService memberRuleSettingService;
	
}
