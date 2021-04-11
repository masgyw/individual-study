package cn.gyw.spring;

import cn.gyw.spring.db.tx.TransactionConfig;
import cn.gyw.spring.db.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcTxTest {

    @Test
    public void testTx() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransactionConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
    }
}
