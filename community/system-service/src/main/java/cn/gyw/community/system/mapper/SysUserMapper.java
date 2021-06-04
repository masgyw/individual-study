package cn.gyw.community.system.mapper;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.platform.common.web.base.mgb.BaseDao;
import cn.gyw.platform.common.web.model.QueryExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseDao<SysUser> {

    UserDto findWithRole(QueryExample example);
}
