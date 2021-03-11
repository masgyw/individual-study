package cn.gyw.spring.config;

import cn.gyw.spring.enums.DataSourceType;
import cn.gyw.spring.external.RoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = {"classpath:db/db.properties"})
// @ComponentScan(value = "cn.gyw.spring")
// 开启声明式事务，proxyTargetClass：是否强制使用基于Cglib类代理
@EnableTransactionManagement(proxyTargetClass = false)
public class DBConfig {

    /**
     * 没有提供池化连接的机制；每次调用 getConnectionO方法获取新连接时，只是简单地创建一个新的连接。
     * 因此，这个数据源类比较适合在单元测试或简单的独立应用中使用
     */
    @Bean(name = "masterDataSource")
    public DataSource dataSourceMaster(@Value("${db.master.driverClassName}") String driverClassName,
                                 @Value("${db.master.url}") String url,
                                 @Value("${db.master.username}") String userName,
                                 @Value("${db.master.password}") String password) {
        return createDataSource(driverClassName, url, userName, password);
    }

    @Bean(name = "slaverDataSource")
    public DataSource dataSourceSlaver(@Value("${db.slaver.driverClassName}") String driverClassName,
                                 @Value("${db.slaver.url}") String url,
                                 @Value("${db.slaver.username}") String userName,
                                 @Value("${db.slaver.password}") String password) {
        return createDataSource(driverClassName, url, userName, password);
    }

    // 内部调用
    private DataSource createDataSource(String driver, String url, String user, String passwd) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(passwd);
        return dataSource;
    }

    @Bean
    public DataSource dataSource(@Autowired @Qualifier(value = "masterDataSource") DataSource master,
                                 @Autowired @Qualifier(value = "slaverDataSource") DataSource slaver) {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(master);

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceType.MASTER, master);
        dataSourceMap.put(DataSourceType.SLAVER, slaver);

        routingDataSource.setTargetDataSources(dataSourceMap);

        return routingDataSource;
    }

    /**
     * 事务管理工厂
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Autowired DataSource dataSource) {
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);

        return transactionManager;
    }

    /**
     * spring jdbc template
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
