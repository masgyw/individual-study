package cn.gyw.community.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Menu;
import cn.gyw.community.system.dto.MenuDto;
import cn.gyw.community.system.service.MenuService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu,MenuDto> {

    @Autowired
    private MenuService menuService;
	
}
