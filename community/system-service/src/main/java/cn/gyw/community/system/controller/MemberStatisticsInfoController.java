package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.MemberStatisticsInfo;
import cn.gyw.community.system.dto.MemberStatisticsInfoDto;
import cn.gyw.community.system.service.MemberStatisticsInfoService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/memberStatisticsInfo")
public class MemberStatisticsInfoController extends BaseController<MemberStatisticsInfo,MemberStatisticsInfoDto> {

    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;
	
}
