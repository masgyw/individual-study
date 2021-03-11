package cn.gyw.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 事务测试的用户service
 */
@Service
public class TxUserService {

    private Logger log = LoggerFactory.getLogger(TxUserService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NESTED)
    // @DataSourceUsage(DataSourceType.SLAVER)
    public List<Map<String, Object>> findUsers() {
        String sql = "select * from user";
        List<Map<String, Object>> datas = jdbcTemplate.queryForList(sql);
        log.debug("查询全部数据: {}", datas);

        // 事务管理插入
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.out.println("send email after transaction commit...");
            }
        });

        return datas;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser() {
        String sql = "insert into user(name,age) values(?,?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setInt(2, 27);
            }
        };
        int result = jdbcTemplate.update(sql, setter);
        log.debug("影响行数:{}", result);
    }

}
