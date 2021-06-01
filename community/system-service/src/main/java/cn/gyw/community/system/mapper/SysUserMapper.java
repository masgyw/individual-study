package cn.gyw.community.system.mapper;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.platform.common.web.base.mgb.BaseDao;
import cn.gyw.platform.common.web.model.QueryExample;

public interface SysUserMapper extends BaseDao<SysUser> {

    UserDto findWithRole(QueryExample example);
}
