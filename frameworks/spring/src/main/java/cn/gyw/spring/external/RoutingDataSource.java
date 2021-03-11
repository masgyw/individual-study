package cn.gyw.spring.external;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源切换器
 *
 * 方法一：在应用配置中配置 数据源信息
 * 方法二：在数据库中动态配置数据源表（若配置库挂了，数据源无法获取，考虑zk）
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceManager.get();
    }
}
