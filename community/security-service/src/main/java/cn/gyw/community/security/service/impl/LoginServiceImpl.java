package cn.gyw.community.security.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;

import cn.gyw.community.security.domain.LoginResultDetails;
import cn.gyw.community.security.domain.ResultDetails;
import cn.gyw.community.security.model.CommunityUser;
import cn.gyw.community.security.service.LoginService;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Override
	public LoginResultDetails get() {
		ResultDetails resultDetails = new ResultDetails();
		resultDetails.setSuccess(false);
		resultDetails.setStatus(HttpStatus.OK.value());
		resultDetails.setMessage("登陆成功！");
		resultDetails.setTimestamp(LocalDateTime.now());
		CommunityUser user = new CommunityUser();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		DecodedJWT claims = (DecodedJWT) authentication.getDetails();

		user.setUsername(authentication.getName());
		user.setExpirationTime(claims.getExpiresAt().getTime());
		user.setPower(claims.getClaim("authorities").toString());
		
		LoginResultDetails loginResultDetails = new LoginResultDetails();
		loginResultDetails.setUser(user);
		loginResultDetails.setResultDetails(resultDetails);
		loginResultDetails.setStatus(200);
		return loginResultDetails;
	}
}
