package cn.gyw.spring.db.service;

import cn.gyw.spring.db.DataSourceUsage;
import cn.gyw.spring.db.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 角色操作
 */
@Service
public class TxRoleService {

    private Logger log = LoggerFactory.getLogger(TxRoleService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    @DataSourceUsage(DataSourceType.SLAVER)
    public void findRoles() {
        String sql = "select * from role";
        List<Map<String, Object>> datas = jdbcTemplate.queryForList(sql);
        log.debug("查询全部数据: {}", datas);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void addRole() {
        String sql = "insert into role(roleName) values(?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, UUID.randomUUID().toString());
            }
        };
        int result = jdbcTemplate.update(sql, setter);
        throw new RuntimeException("run error");
        // log.debug("影响行数:{}" + result);
    }
}
