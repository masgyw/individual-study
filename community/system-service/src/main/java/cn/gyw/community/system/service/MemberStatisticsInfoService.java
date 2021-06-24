package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberStatisticsInfo;
import cn.gyw.community.system.dao.MemberStatisticsInfoMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberStatisticsInfoService extends BaseService<MemberStatisticsInfo> {

	@Autowired
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;
}
