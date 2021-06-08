package cn.gyw.community.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"cn.gyw.community.search.dao"})
public class MybatisConfig {
}
