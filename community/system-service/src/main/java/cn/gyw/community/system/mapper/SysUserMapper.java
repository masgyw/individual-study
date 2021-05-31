package cn.gyw.community.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.platform.common.web.model.QueryExample;

public interface SysUserMapper extends BaseMapper<SysUser> {


    // 必须配置 mybatis mapper-locations
    // @Param(Constants.WRAPPER) Wrapper wrapper
    UserDto findWithRole(QueryExample example);
}
