package cn.gyw.community.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户查找类，方便返回未找到用户名异常
 */
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
    private List<UserDetails> userList = new ArrayList<>();

    public CustomUserDetailsService() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("123456")).authorities(WebSecurityConfig.USER).build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("123456")).authorities(WebSecurityConfig.ADMIN).build();
        userList.add(user);
        userList.add(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	LOGGER.debug("User name [{}] ready login...", username);
        for (UserDetails userDetails : userList) {
            if (userDetails.getUsername().equals(username)) {
            	System.out.println(userDetails.getAuthorities());
                return new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            }
        }
        throw new UsernameNotFoundException("用户名不存在，请检查用户名或注册！");
    }
}
