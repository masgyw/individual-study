package cn.gyw.community.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.gyw.community.security.domain.ErrorDetails;
import cn.gyw.community.security.model.CommunityUser;
import cn.gyw.community.security.model.LoginDetails;
import cn.gyw.community.security.service.LoginCountService;
import cn.gyw.community.security.service.VerifyCodeService;
import cn.gyw.community.security.util.TokenAuthenticationHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * JWT 登陆过滤器
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtLoginFilter.class);

	private final VerifyCodeService verifyCodeService;

	private final LoginCountService loginCountService;

	/**
	 * @param defaultFilterProcessesUrl 配置要过滤的地址，即登陆地址
	 * @param authenticationManager     认证管理器，校验身份时会用到
	 * @param loginCountService
	 */
	public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager,
			VerifyCodeService verifyCodeService, LoginCountService loginCountService) {
		super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
		this.loginCountService = loginCountService;
		// 为 AbstractAuthenticationProcessingFilter 中的属性赋值
		setAuthenticationManager(authenticationManager);
		this.verifyCodeService = verifyCodeService;
	}

	/**
	 * 提取用户账号密码进行验证
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
		// 判断是否要抛出 登陆请求过快的异常
		loginCountService.judgeLoginCount(httpServletRequest);
		LOGGER.info("开始验证用户...");
		// 获取 CommunityUser 对象
		CommunityUser user = new ObjectMapper().readValue(httpServletRequest.getInputStream(), CommunityUser.class);
		LOGGER.info("用户：{}", user);
		// 验证码验证
		verifyCodeService.verify(httpServletRequest.getSession().getId(), user.getVerifyCode());
		// 对 html 标签进行转义，防止 XSS 攻击
		String username = user.getUsername();
		LOGGER.debug("Username :{}", username);
		username = HtmlUtils.htmlEscape(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,
				user.getPassword(), user.getAuthorities());
		// 添加验证的附加信息
		// 包括验证码信息和是否记住我
		token.setDetails(new LoginDetails(user.getRememberMe(), user.getVerifyCode()));
		LOGGER.debug("getAuthenticationManager token :{}", token);
		// 进行登陆验证
		return getAuthenticationManager().authenticate(token);
	}

	/**
	 * 登陆成功回调
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		LOGGER.debug("User login success!!");
		loginCountService.cleanLoginCount(request);
		response.setStatus(HttpServletResponse.SC_OK);
		// 登陆成功
		TokenAuthenticationHelper.addAuthentication(request, response, authResult);
	}

	/**
	 * 登陆失败回调
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// 错误请求次数加 1
		loginCountService.addLoginCount(request, 1);
		// 向前端写入数据
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorDetails.setMessage("登陆失败！");
		errorDetails.setError(failed.getLocalizedMessage());
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setPath(request.getServletPath());
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(errorDetails));
		out.flush();
		out.close();
	}
}
