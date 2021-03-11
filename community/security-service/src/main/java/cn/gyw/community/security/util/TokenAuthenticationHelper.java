package cn.gyw.community.security.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.gyw.community.security.domain.LoginResultDetails;
import cn.gyw.community.security.domain.ResultDetails;
import cn.gyw.community.security.model.CommunityUser;
import cn.gyw.community.security.model.LoginDetails;

/**
 * Token 认证支撑类
 */
public class TokenAuthenticationHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationHelper.class);

	/**
	 * 未设置记住我时 token 过期时间
	 */
	private static final long EXPIRATION_TIME = 7200000;

	/**
	 * 记住我时 cookie token 过期时间
	 */
	private static final int COOKIE_EXPIRATION_TIME = 1296000;

	/**
	 * 设置登陆成功后令牌返回
	 */
	public static void addAuthentication(HttpServletRequest request, HttpServletResponse response,
			Authentication authResult) throws IOException {
		LOGGER.debug("User login success, return token.");
		// 获取用户登陆角色
		Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
		// 遍历用户角色
		StringBuffer stringBuffer = new StringBuffer();
		authorities.forEach(authority -> {
			stringBuffer.append(authority.getAuthority()).append(",");
		});

		long expirationTime = EXPIRATION_TIME;
		// 处理登陆附加信息
		LoginDetails loginDetails = (LoginDetails) authResult.getDetails();
		if (loginDetails.getRememberMe() != null && loginDetails.getRememberMe()) {
			expirationTime = COOKIE_EXPIRATION_TIME * 1000;
		}

		Map<String, String> claimMap = new HashMap<>();
		claimMap.put("authorities", stringBuffer.toString());
		String token = JwtUtil.createToken(authResult.getName(), claimMap, expirationTime,
				RSAUtil.getDefaultPublicKey(), RSAUtil.getDefaultPrivateKey());

		// 向前端写入数据
		LoginResultDetails loginResultDetails = new LoginResultDetails();
		ResultDetails resultDetails = new ResultDetails();
		resultDetails.setStatus(HttpStatus.OK.value());
		resultDetails.setMessage("登陆成功！");
		resultDetails.setSuccess(true);
		resultDetails.setTimestamp(LocalDateTime.now());
		resultDetails.setToken(token);

		CommunityUser user = new CommunityUser();
		user.setUsername(authResult.getName());
		user.setPower(stringBuffer.toString());
		user.setExpirationTime(System.currentTimeMillis() + expirationTime);

		loginResultDetails.setResultDetails(resultDetails);
		loginResultDetails.setUser(user);
		loginResultDetails.setStatus(200);
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(loginResultDetails));
		out.flush();
		out.close();
	}

	/**
	 * 对请求的验证
	 */
	public static Authentication getAuthentication(HttpServletRequest request) {
		LOGGER.debug("服务器对请求开始验证...");
		String token = getJwtToken(request);
		LOGGER.debug("Get token header is ：{}", token);
		DecodedJWT decodedJWT = JWT.decode(token);
		Map<String, Claim> claims = decodedJWT.getClaims();
		LOGGER.debug("authorities :{}", claims.get("authorities").asString());
		// 获取用户权限
		Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get("authorities").asString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		String userName = decodedJWT.getSubject();
		LOGGER.debug("Token userName ：{}", userName);

		if (userName != null) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userName, null, authorities);
			usernamePasswordAuthenticationToken.setDetails(claims);

			LOGGER.debug("usernamePasswordAuthenticationToken ：{}", usernamePasswordAuthenticationToken);
			return usernamePasswordAuthenticationToken;
		}
		return null;
	}
	
	protected static String getJwtToken(HttpServletRequest request) {
		String token = request.getHeader(JwtUtil.AUTHORIZATION);
		if (StringUtils.isBlank(token) || !token.startsWith(JwtUtil.TOKEN_PREFIX)) {
			throw new RuntimeException("Token is null or prefix error!");
		}
		return StringUtils.removeStart(token, JwtUtil.TOKEN_PREFIX);
	}
}
