package cn.gyw.community.system.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.community.system.enums.SystemExceptionEnum;
import cn.gyw.community.system.mapper.SysUserMapper;
import cn.gyw.community.system.service.ISysUserService;
import cn.gyw.platform.common.web.base.mgb.BaseService;
import cn.gyw.platform.common.web.model.QueryExample;
import cn.gyw.platform.common.web.utils.JwtTokenUtil;
import tk.mybatis.mapper.entity.Example;

@Service(value = "sysUserService")
public class SysUserServiceImpl extends BaseService<SysUser> implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
    @Override
    public UserDto findWithRole(QueryExample queryExample) {
        return this.sysUserMapper.findWithRole(queryExample);
    }

	@Override
	public UserDto login(String userName, String password) {
		Example example = new Example(SysUser.class);
		example.createCriteria().andEqualTo(SysUser.USER_NAME, userName)
			.andEqualTo(SysUser.PASSWORD, password);
        
        SysUser user = sysUserMapper.selectOneByExample(example);
        SystemExceptionEnum.USER_NOT_EXISTS.assertNotNull(user);
        
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setToken(JwtTokenUtil.getToken(user.getUid().toString()));
		return userDto;
	}
}
