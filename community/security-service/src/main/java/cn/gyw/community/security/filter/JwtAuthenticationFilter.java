package cn.gyw.community.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.gyw.community.security.util.TokenAuthenticationHelper;

/**
 * jwt 对请求的验证
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		LOGGER.debug("Jwt 验证请求");
		try {
			Authentication authentication = TokenAuthenticationHelper.getAuthentication(httpServletRequest);
			LOGGER.debug("authentication is {}", authentication);
			// 对用 token 获取到的用户进行校验
			SecurityContextHolder.getContext().setAuthentication(authentication);
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} catch (Exception e) {
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalid, check .");
		}
	}
}
