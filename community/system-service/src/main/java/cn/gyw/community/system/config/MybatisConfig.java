package cn.gyw.community.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
@MapperScan({"cn.gyw.community.system.mapper","cn.gyw.community.systems.dao"})
public class MybatisConfig {
}
