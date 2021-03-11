package cn.gyw.community.system.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.gyw.community.system.api.ISysUserServiceAPi;
import cn.gyw.community.system.dto.UserDto;
import cn.gyw.community.system.entity.SysUser;
import cn.gyw.community.system.enums.SystemExceptionEnum;
import cn.gyw.community.system.service.IRedisService;
import cn.gyw.community.system.service.ISysUserService;
import cn.gyw.components.web.base.mybatisplus.BaseController;
import cn.gyw.components.web.model.QueryExample;
import cn.gyw.components.web.utils.JwtTokenUtil;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author guanyw
 * @since 2020-03-05
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController<SysUser, UserDto> implements ISysUserServiceAPi {

    @Autowired
    private ISysUserService sysUserService;
    
    @Autowired
    private IRedisService redisService;

    /**
     * 根据token 查询
     * 
     * @return
     */
    @GetMapping(path = "/token")
    public UserDto queryById(@RequestParam(value = "token", required = false) String token) {
        String userId = JwtTokenUtil.getUserId(token);
        QueryExample example = new QueryExample();
        QueryExample.Criteria criteria = example.createCritria();
        criteria.eq(SysUser.USER_ID, userId);
        UserDto user = sysUserService.findWithRole(example);
        return user;
    }

    /**
     * 登录
     * 
     * @param userDto
     * @return
     */
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto login(@RequestBody UserDto userDto) {
        log.info("当前登录用户：{}", userDto);
        UserDto dbUser = this.sysUserService.login(userDto.getUserName(), userDto.getPassword());
        // 统计
        this.redisService.userLogin(dbUser.getUid().toString());
        return dbUser;
    }

    /**
     * 注册
     * 
     * @param userDto
     * @return
     */
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean register(@RequestBody UserDto userDto) {
        log.info("注册用户：{}", userDto);
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userDto, user);
//        user.setPassword(EncryptUtil.passwordByMD5(userDto.getPasswd()));
        user.setPassword(userDto.getPassword());
        return this.sysUserService.save(user);
    }

    /**
     * 登出
     * 
     * @return
     */
    @PostMapping(path = "/logout", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean logout(@RequestBody Map<String,String> reqBody) {
        log.info("logout request body:{}", reqBody);
        return true;
    }

    @Override
    public String checkUser(String userId) {
        System.out.println("1233333333333333333333333");
        return "true";
    }
}
