package cn.gyw.community.content.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
@MapperScan({"cn.gyw.community.content.mapper","cn.gyw.community.content.dao"})
public class MybatisConfig {
}
