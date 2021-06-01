package cn.gyw.community.system.service;

import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.platform.common.web.base.mgb.IBaseService;
import cn.gyw.platform.common.web.model.QueryExample;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guanyw
 * @since 2020-03-05
 */
public interface ISysUserService extends IBaseService<SysUser> {

    UserDto findWithRole(QueryExample example);
    
    /**
     * 登陆
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    UserDto login(String userName, String password);
}
