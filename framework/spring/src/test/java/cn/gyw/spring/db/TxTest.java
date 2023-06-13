package cn.gyw.spring.db;

import cn.gyw.spring.db.tx.TxPhoneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @date 2023/4/7
 */
public class TxTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext
                = new AnnotationConfigApplicationContext(TransactionConfig.class);

        TxPhoneService service = configApplicationContext.getBean(TxPhoneService.class);
        service.selectList();

        System.out.println("service = " + service);
    }
}
