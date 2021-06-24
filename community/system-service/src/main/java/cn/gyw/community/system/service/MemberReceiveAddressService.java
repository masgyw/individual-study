package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.MemberReceiveAddress;
import cn.gyw.community.system.dao.MemberReceiveAddressMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberReceiveAddressService extends BaseService<MemberReceiveAddress> {

	@Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;
}
