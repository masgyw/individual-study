package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.GrowthChangeHistory;
import cn.gyw.community.system.dao.GrowthChangeHistoryMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrowthChangeHistoryService extends BaseService<GrowthChangeHistory> {

	@Autowired
    private GrowthChangeHistoryMapper growthChangeHistoryMapper;
}
