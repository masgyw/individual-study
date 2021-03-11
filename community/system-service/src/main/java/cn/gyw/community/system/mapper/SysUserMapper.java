package cn.gyw.community.system.mapper;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.components.web.model.QueryExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser> {


    // 必须配置 mybatis mapper-locations
    // @Param(Constants.WRAPPER) Wrapper wrapper
    UserDto findWithRole(QueryExample example);
}
