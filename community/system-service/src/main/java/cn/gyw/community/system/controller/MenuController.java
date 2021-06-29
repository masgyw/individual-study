package cn.gyw.community.system.controller;

import cn.gyw.community.system.dto.MenuNode;
import cn.gyw.community.system.enums.SystemRespEnum;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @PostMapping("/create")
    public BaseResponse create(@RequestBody MenuDto menuDto) {
        int count = menuService.add(menuDto);
        if (count > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.error(SystemRespEnum.ADD_MENU_FAILED);
    }
}
