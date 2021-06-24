package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.Resource;
import cn.gyw.community.system.dao.ResourceMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends BaseService<Resource> {

	@Autowired
    private ResourceMapper resourceMapper;
}
