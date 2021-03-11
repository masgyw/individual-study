package cn.gyw.spring.external;

import cn.gyw.spring.enums.DataSourceType;

/**
 * 数据源管理器
 */
public final class DataSourceManager {

    private final static ThreadLocal<DataSourceType> datasources = ThreadLocal.withInitial(() -> {
        return DataSourceType.MASTER;
    });

    public static DataSourceType get() {
        return datasources.get();
    }

    public static void set(DataSourceType type) {
        datasources.set(type);
    }

    public static void reset() {
        datasources.set(DataSourceType.MASTER);
    }

    private DataSourceManager() {
    }
}
