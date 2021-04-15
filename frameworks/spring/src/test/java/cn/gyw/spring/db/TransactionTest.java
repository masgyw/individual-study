package cn.gyw.spring.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.Statement;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBAutoRouteConfig.class})
public class TransactionTest {

    @Test
    public void jdbcTransaction() {
        try {
            // 获取连接
            Connection connection = null;
            // 通过TransactionManager 获得可以回滚的机会
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.execute("");

            connection.commit();
            //connection.rollback();

        } catch (Exception e) {

        }
    }
}
