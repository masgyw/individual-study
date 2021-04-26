package cn.gyw.gbatis.executor;

import cn.gyw.gbatis.config.Configuration;
import cn.gyw.gbatis.config.MappedStatement;
import cn.gyw.gbatis.parameter.ParameterHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认执行器
 */
public class DefaultExecutor implements Executor {

    private final Configuration configuration;

    public DefaultExecutor(Configuration configuration) {
        super();
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> query(MappedStatement mappedStatement, Object... parameters) throws SQLException {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(mappedStatement, parameters);
    }
}
