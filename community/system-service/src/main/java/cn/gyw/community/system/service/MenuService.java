package cn.gyw.community.system.service;

import cn.gyw.community.system.entity.Menu;
import cn.gyw.community.system.dao.MenuMapper;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends BaseService<Menu> {

	@Autowired
    private MenuMapper menuMapper;
}
