package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.ResourceCategory;
import cn.gyw.community.system.dto.ResourceCategoryDto;
import cn.gyw.community.system.service.ResourceCategoryService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController extends BaseController<ResourceCategory,ResourceCategoryDto> {

    @Autowired
    private ResourceCategoryService resourceCategoryService;
	
}
