package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.IntegrationConsumeSetting;
import cn.gyw.community.system.dao.IntegrationConsumeSettingMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationConsumeSettingService extends BaseService<IntegrationConsumeSetting> {

	@Autowired
    private IntegrationConsumeSettingMapper integrationConsumeSettingMapper;
}
