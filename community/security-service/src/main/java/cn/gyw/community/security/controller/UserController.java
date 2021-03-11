package cn.gyw.community.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import cn.gyw.community.security.config.WebSecurityConfig;
import cn.gyw.community.security.domain.CustomData;
import cn.gyw.community.security.domain.LoginResultDetails;
import cn.gyw.community.security.domain.ResultDetails;
import cn.gyw.community.security.service.LoginService;
import cn.gyw.community.security.service.SystemDataService;



/**
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final SystemDataService systemDataService;


    private final LoginService loginService;

    @Autowired
    public UserController(SystemDataService systemDataService, LoginService loginService) {
        this.systemDataService = systemDataService;
        this.loginService = loginService;
    }

    @GetMapping("/loginJudge")
    public LoginResultDetails showPage() {
        return loginService.get();
    }

    @PostMapping("/data")
    public CustomData create(@RequestBody CustomData customData) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String data = customData.getData();
        data = HtmlUtils.htmlEscape(data);
        customData.setData("#这是用户创建的数据：" + data);
        return systemDataService.create(customData);
    }


    @DeleteMapping("/data/{id}")
    public ResultDetails delete(@PathVariable("id") String id) {
        return systemDataService.delete(id, WebSecurityConfig.USER);
    }
}
