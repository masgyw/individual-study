package cn.gyw.community.system.service;

import cn.gyw.community.system.dto.MenuDto;
import cn.gyw.community.system.dto.MenuNode;
import cn.gyw.community.system.entity.Menu;
import cn.gyw.community.system.dao.MenuMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService extends BaseService<Menu> {

	@Autowired
    private MenuMapper menuMapper;

    /**
     * 树形结构返回所有菜单列表
     */
    public List<MenuNode> treeList() {
        List<Menu> menuList = menuMapper.selectAll();
        List<MenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    private MenuNode covertMenuNode(Menu menu, List<Menu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    public int add(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        updateLevel(menu);
        return menuMapper.insertSelective(menu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(Menu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            Menu parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }
}
