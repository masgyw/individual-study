package cn.gyw.community.system.controller;

import cn.gyw.community.system.dto.MenuNode;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import cn.gyw.community.system.entity.Menu;
import cn.gyw.community.system.dto.MenuDto;
import cn.gyw.community.system.service.MenuService;
import cn.gyw.platform.common.web.base.mgb.BaseController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu,MenuDto> {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/treeList")
    public BaseResponse treeList() {
        List<MenuNode> list = menuService.treeList();
        return DataResponse.success(list);
    }
}
