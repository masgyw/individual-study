package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.IntegrationConsumeSetting;
import cn.gyw.community.system.dto.IntegrationConsumeSettingDto;
import cn.gyw.community.system.service.IntegrationConsumeSettingService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/integrationConsumeSetting")
public class IntegrationConsumeSettingController extends BaseController<IntegrationConsumeSetting,IntegrationConsumeSettingDto> {

    @Autowired
    private IntegrationConsumeSettingService integrationConsumeSettingService;
	
}
