package cn.gyw.community.system.service;

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
}
