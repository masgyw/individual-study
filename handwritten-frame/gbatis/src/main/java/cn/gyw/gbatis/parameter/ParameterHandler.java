package cn.gyw.gbatis.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 参数处理器
 */
public class ParameterHandler {

    private PreparedStatement ps;

    public ParameterHandler(PreparedStatement preparedStatement) {
        this.ps = preparedStatement;
    }

    /**
     * 设置参数
     *
     * @param parameters
     */
    public void setParameters(Object[] parameters) {
        try {
            for (int i = 0, len = parameters.length; i < len; i++) {
                Object param = parameters[i];
                if (param instanceof Integer) {
                    ps.setInt(i + 1, (Integer) param);
                } else if (param instanceof Long) {
                    ps.setLong(i + 1, (Long) param);
                } else if (param instanceof String) {
                    ps.setString(i + 1, (String) param);
                } else if (param instanceof Boolean) {
                    ps.setBoolean(i + 1, (Boolean) param);
                } else {
                    ps.setString(i + 1, (String) param);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
