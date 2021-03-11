package cn.gyw.community.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 授权服务机制
 * 
 */
@Configuration
@EnableAuthorizationServer // 开启配置 OAuth 2.0 认证授权服务
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/**
	 * 定义授权服务器策略
	 * 
	 * ClientDetailsServiceConfigurer：使用内存或 JDBC 方式实现获取已注册的客户端详情 clientId：客户端标识 ID
	 * secret：客户端安全码 scope：客户端访问范围，默认为空则拥有全部范围 authorizedGrantTypes：客户端使用的授权类型，默认为空
	 * authorities：客户端可使用的权限
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// secret 里面的密码必须要填写中括号{noop} 或者相对应的加密方式 例如：{bcrypt}、{sha256}
		String secret = new BCryptPasswordEncoder().encode("secret");
		
		clients.inMemory() // 内存存储客户端信息
				// client_id
				.withClient("client")
				// client_secret，必须制定加密方式
				.secret("{bcrypt}" + secret)
				// 允许授权的类型 authorization_code:授权码模式；token：简化模式，去掉授权码
				.authorizedGrantTypes("authorization_code")
				// 允许的授权范围
				.scopes("app")
				// 资源列表
				.redirectUris("http://localhost")
				.accessTokenValiditySeconds(7_200)
				;
	}

	/**
	 * 配置授权服务器的安全
	 * 
	 * 默认的设置覆盖到了绝大多数需求，所以一般情况下不需要做任何事情
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
		// 允许表单登陆
//		security.allowFormAuthenticationForClients();
	}

	/**
	 * 配置授权类型
	 * 
	 * AuthorizationServerEndpointsConfigurer:默认是支持除了密码授权外所有标准授权类型
	 * authenticationManager：认证管理器，当你选择了资源所有者密码（password）授权类型的时候，设置这个属性注入一个 AuthenticationManager 对象
	 * userDetailsService：可定义自己的 UserDetailsService 接口实现
	 * authorizationCodeServices：用来设置收取码服务的（即 AuthorizationCodeServices 的实例对象），主要用于 "authorization_code" 授权码类型模式
	 * implicitGrantService：这个属性用于设置隐式授权模式，用来管理隐式授权模式的状态
	 * tokenGranter：完全自定义授权服务实现（TokenGranter 接口实现），只有当标准的四种授权模式已无法满足需求时
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.authenticationManager(authenticationManager);
		// token 存储在内存中
		endpoints.tokenStore(new InMemoryTokenStore());
		
		//配置授权端点 URL
//		endpoints.pathMapping("/test", "/ho");
	}

//	@Autowired
//	private DataSource dataSource;
//	@Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private TokenStore tokenStore;
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//    /**
//     * 配置 oauth_client_details【client_id和client_secret等】信息的认证【检查ClientDetails的合法性】服务
//     * 设置 认证信息的来源：数据库 (可选项：数据库和内存,使用内存一般用来作测试)
//     * 自动注入：ClientDetailsService的实现类 JdbcClientDetailsService (检查 ClientDetails 对象)
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc(dataSource);
//    }
//
//
//    /**
//     * 密码模式下配置认证管理器 AuthenticationManager,并且设置 AccessToken的存储介质tokenStore,如果不设置，则会默认使用内存当做存储介质。
//     * 而该AuthenticationManager将会注入 2个Bean对象用以检查(认证)
//     * 1、ClientDetailsService的实现类 JdbcClientDetailsService (检查 ClientDetails 对象)
//     * 2、UserDetailsService的实现类 CustomUserDetailsService (检查 UserDetails 对象)
//     * 
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
//            throws Exception {
//        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore).userDetailsService(userDetailsService);
//    }
//
//    /**
//     *  配置：安全检查流程
//     *  默认过滤器：BasicAuthenticationFilter
//     *  1、oauth_client_details表中clientSecret字段加密【ClientDetails属性secret】
//     *  2、CheckEndpoint类的接口 oauth/check_token 无需经过过滤器过滤，默认值：denyAll()
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients();//允许客户表单认证
//        security.passwordEncoder(new BCryptPasswordEncoder());//设置oauth_client_details中的密码编码器
//        security.checkTokenAccess("permitAll()");//对于CheckEndpoint控制器[框架自带的校验]的/oauth/check端点允许所有客户端发送器请求而不会被Spring-security拦截
//    }
}
