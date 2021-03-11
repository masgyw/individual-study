package cn.gyw.community.system.service.impl;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.community.system.enums.SystemExceptionEnum;
import cn.gyw.community.system.mapper.SysUserMapper;
import cn.gyw.community.system.service.ISysUserService;
import cn.gyw.components.web.model.QueryExample;
import cn.gyw.components.web.utils.JwtTokenUtil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service(value = "sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public UserDto findWithRole(QueryExample queryExample) {
        return baseMapper.findWithRole(queryExample);
    }

	@Override
	public UserDto login(String userName, String password) {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.USER_NAME, userName);
        queryWrapper.eq(SysUser.PASSWORD, password);
        
        SysUser user = getOne(queryWrapper);
        SystemExceptionEnum.USER_NOT_EXISTS.assertNotNull(user);
        
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setToken(JwtTokenUtil.getToken(user.getUid().toString()));
		return userDto;
	}
}
