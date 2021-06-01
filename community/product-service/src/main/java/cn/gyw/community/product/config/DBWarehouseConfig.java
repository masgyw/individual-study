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
//import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
//
///**
// * 库存数据源配置
// */
//@Configuration
//@MapperScan(value="cn.gyw.community.product.mapper.warehouse", sqlSessionFactoryRef = "warehouseSqlSessionFactory")
//public class DBWarehouseConfig {
//
//	@Bean("warehouseDataSource")
//	public DataSource warehouseDataSource(@Value("${datasource.warehouse.driverClassName}") String driverClass,
//			@Value("${datasource.warehouse.url}") String url, @Value("${datasource.warehouse.username}") String username,
//			@Value("${datasource.warehouse.password}") String password) {
//		// 使用mysql的分布式驱动，支持MySql5.*、MySql8.* 以上版本
//		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
//		mysqlXADataSource.setUrl(url);
//		mysqlXADataSource.setUser(username);
//		mysqlXADataSource.setPassword(password);
//		
//		AtomikosDataSourceBean xaDataSourceBean = new AtomikosDataSourceBean();
//		xaDataSourceBean.setXaDataSource(mysqlXADataSource);
//		xaDataSourceBean.setUniqueResourceName("warehouseDataSource");
//		xaDataSourceBean.setPoolSize(3);
////		xaDataSourceBean.setMinPoolSize();
////		xaDataSourceBean.setMaxPoolSize();
////		xaDataSourceBean.setMaxIdleTime();
////		xaDataSourceBean.setMaxLifetime();
////		xaDataSourceBean.setConcurrentConnectionValidation();
//		xaDataSourceBean.setTestQuery("select 1");
//        return xaDataSourceBean;
//	}
//	
//	@Bean("warehouseSqlSessionFactory")
//	public SqlSessionFactory warehouseSqlSessionFactory(@Qualifier("warehouseDataSource") DataSource dataSource,
//			@Value("${mybatis.warehouse.mapperLocations}") String mapperLocations) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
////		sqlSessionFactoryBean.setTypeAliasesPackage("");
//		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//		return sqlSessionFactoryBean.getObject();
//	}
//}
