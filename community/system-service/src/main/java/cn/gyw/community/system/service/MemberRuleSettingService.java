package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberRuleSetting;
import cn.gyw.community.system.dao.MemberRuleSettingMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRuleSettingService extends BaseService<MemberRuleSetting> {

	@Autowired
    private MemberRuleSettingMapper memberRuleSettingMapper;
}
