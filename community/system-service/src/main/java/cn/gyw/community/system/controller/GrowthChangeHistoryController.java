package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.GrowthChangeHistory;
import cn.gyw.community.system.dto.GrowthChangeHistoryDto;
import cn.gyw.community.system.service.GrowthChangeHistoryService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/growthChangeHistory")
public class GrowthChangeHistoryController extends BaseController<GrowthChangeHistory,GrowthChangeHistoryDto> {

    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;
	
}
