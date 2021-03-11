package cn.gyw.gbatis.executor;

import cn.gyw.gbatis.config.Configuration;
import cn.gyw.gbatis.config.MappedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultExecutor implements Executor {

    private final Configuration configuration;

    public DefaultExecutor(Configuration configuration) {
        super();
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> query(MappedStatement mappedStatement, Object parameter) throws SQLException {
        doQuery(mappedStatement, parameter);
        return new ArrayList<>();
    }

    private void doQuery(MappedStatement mappedStatement, Object parameter) {
        Connection connection = null;
        try {
            // 驱动加载
            Class.forName(configuration.getDriverClass());
            connection = DriverManager.getConnection(configuration.getDriverUrl(), configuration.getUsername(), configuration.getPassword());

            PreparedStatement ps = connection.prepareStatement(mappedStatement.getSql());
            ResultSet resultSet = ps.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            System.out.println("column : " + col);
            while (resultSet.next()) {
                for (int i = 1 ; i <= col ; i ++) {
                    System.out.println(resultSet.getObject(i));
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
