package cn.gyw.community.system.dto;

import cn.gyw.community.system.entity.Menu;

import java.util.List;

public class MenuNode extends Menu {

    private List<MenuNode> children;

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }
}
