package cn.gyw.gbatis.executor;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 结果集处理器
 */
public class ResultSetHandler {

    public <T> List<T> handle(ResultSet resultSet, Class<?> type) {
        List<T> resultList = new ArrayList<>();
        try {
            T result = (T) type.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int colCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= colCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Field field = type.getDeclaredField(columnName);
                    field.setAccessible(true);
                    Object value = resultSet.getObject(columnName);
                    field.set(result, value);
                }
                resultList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
