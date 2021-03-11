package cn.gyw.components.web.log;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"cn.gyw.components.web.log"})
public class ApiLogConfig {

    @Value("${apiLog.datasource.driverClass}")
    private String driverClass;

    @Value("${apiLog.datasource.url}")
    private String url;

    @Value("${apiLog.datasource.user}")
    private String user;

    @Value("${apiLog.datasource.password}")
    private String password;

    @Bean("apiLogJdbcTemplate")
    public JdbcTemplate apiLogJdbcTemplate() {
        @SuppressWarnings("resource")
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return new JdbcTemplate(dataSource);
    }
}
