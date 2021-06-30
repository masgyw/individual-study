//package cn.gyw.community.product.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import com.github.pagehelper.PageInterceptor;
//import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
///**
// * 产品数据源配置
// */
//@Configuration
//@MapperScan(value = "cn.gyw.community.product.mapper.product", sqlSessionFactoryRef = "productSqlSessionFactory")
//public class DBProductConfig {
//
//    @Value("${datasource.product.driverClassName}")
//    private String driverClass;
//    @Value("${datasource.product.url}")
//	private String url;
//    @Value("${datasource.product.username}")
//	private String username;
//    @Value("${datasource.product.password}")
//	private String password;
//
//    @Bean("basicProductDS")
//    public DataSource basicProductDS() {
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(url);
//		config.setDriverClassName(driverClass);
//		config.setUsername(username);
//		config.setPassword(password);
//		DataSource dataSource = new HikariDataSource(config);
//		return dataSource;
//    }
//
//    // 多数据源
//    @Bean("productDataSource")
//    public DataSource productDataSource() {
//        // 使用mysql的分布式驱动，支持MySql5.*、MySql8.* 以上版本
//        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
//        mysqlXADataSource.setUrl(url);
//        mysqlXADataSource.setUser(username);
//        mysqlXADataSource.setPassword(password);
//
//        AtomikosDataSourceBean xaDataSourceBean = new AtomikosDataSourceBean();
//        xaDataSourceBean.setXaDataSource(mysqlXADataSource);
//        xaDataSourceBean.setUniqueResourceName("productDataSource");
//        xaDataSourceBean.setPoolSize(3);
////			xaDataSourceBean.setMinPoolSize();
////			xaDataSourceBean.setMaxPoolSize();
////			xaDataSourceBean.setMaxIdleTime();
////			xaDataSourceBean.setMaxLifetime();
////			xaDataSourceBean.setConcurrentConnectionValidation();
//        xaDataSourceBean.setTestQuery("select 1");
//        return xaDataSourceBean;
//    }
//
//    @Bean("productSqlSessionFactory")
//    public SqlSessionFactory productSqlSessionFactory(@Qualifier("basicProductDS") DataSource dataSource,
//                                                      @Value("${mybatis.product.mapperLocations}") String mapperLocations) throws Exception {
//    	org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//    	configuration.addInterceptor(new PageInterceptor());
//    	
//    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setConfiguration(configuration);
////			sqlSessionFactoryBean.setTypeAliasesPackage("");
//        sqlSessionFactoryBean
//                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//}
