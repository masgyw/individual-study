package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.IntegrationChangeHistory;
import cn.gyw.community.system.dto.IntegrationChangeHistoryDto;
import cn.gyw.community.system.service.IntegrationChangeHistoryService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/integrationChangeHistory")
public class IntegrationChangeHistoryController extends BaseController<IntegrationChangeHistory,IntegrationChangeHistoryDto> {

    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;
	
}
