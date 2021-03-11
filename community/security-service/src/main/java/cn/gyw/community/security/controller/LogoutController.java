package cn.gyw.community.security.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyw.community.security.domain.ResultDetails;
import cn.gyw.community.security.util.TokenAuthenticationHelper;

/**
 * 自定义退出
 */
@RestController
public class LogoutController {
	
    @GetMapping("/api/logout")
    public ResultDetails logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = TokenAuthenticationHelper.getAuthentication(request);
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        ResultDetails resultDetails = new ResultDetails();
        resultDetails.setStatus(HttpStatus.OK.value());
        resultDetails.setMessage("退出成功！");
        resultDetails.setTimestamp(LocalDateTime.now());
        return resultDetails;
    }
}
