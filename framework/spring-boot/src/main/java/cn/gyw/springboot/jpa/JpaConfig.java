package cn.gyw.springboot.jpa;

import cn.gyw.platform.configuration.interfaces.IConfiguration;
import cn.gyw.platform.configuration.service.ConfigurationOnFileYaml;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "cn.gyw.springboot.jpa")
@EnableJpaRepositories(basePackages = {"cn.gyw.springboot.jpa"},
repositoryImplementationPostfix = "Impl",
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class JpaConfig {

    private IConfiguration config = new ConfigurationOnFileYaml();

    @Value("${ds.url}")
    private String url;
    @Value("${ds.username}")
    private String userName;
    @Value("${ds.driver-class-name}")
    private String driverClassName;

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(String.format(url, config.getValue("hw-cloud", "datasource.host")));
        dataSource.setUsername(userName);
        dataSource.setPassword(config.getValue("hw-cloud", "datasource.password"));
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    // 配置jpa厂商适配器（参见spring实战p320）
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        // 设置数据库类型（可使用org.springframework.orm.jpa.vendor包下的Database枚举类）
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        // 设置打印sql语句
        jpaVendorAdapter.setShowSql(true);
        // 设置不生成ddl语句
        jpaVendorAdapter.setGenerateDdl(false);
        // 设置hibernate方言
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return jpaVendorAdapter;
    }

    // 配置实体管理器工厂
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        // 注入数据源
        emfb.setDataSource(dataSource);
        // 注入jpa厂商适配器
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        // 设置扫描基本包
        emfb.setPackagesToScan("cn.gyw.springboot.jpa");
        return emfb;
    }

    // 配置jpa事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // 配置实体管理器工厂
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
