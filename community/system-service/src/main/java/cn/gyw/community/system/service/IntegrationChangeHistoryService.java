package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.IntegrationChangeHistory;
import cn.gyw.community.system.dao.IntegrationChangeHistoryMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationChangeHistoryService extends BaseService<IntegrationChangeHistory> {

	@Autowired
    private IntegrationChangeHistoryMapper integrationChangeHistoryMapper;
}
