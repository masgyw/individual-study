package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.ResourceCategory;
import cn.gyw.community.system.dao.ResourceCategoryMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceCategoryService extends BaseService<ResourceCategory> {

	@Autowired
    private ResourceCategoryMapper resourceCategoryMapper;
}
