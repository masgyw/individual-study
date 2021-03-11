package cn.gyw.community.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.gyw.community.security.util.VerifyCodeUtil;

@Configuration
public class RootConfig {
	
    @Bean
    public VerifyCodeUtil verifyCodeUtil() {
        return new VerifyCodeUtil();
    }
}
