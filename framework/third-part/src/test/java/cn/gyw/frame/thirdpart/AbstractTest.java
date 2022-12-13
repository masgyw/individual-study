package cn.gyw.frame.thirdpart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractTest {

    protected static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

    // 启动毫秒数
    protected long startCurrentTimeMillis = 0;

    protected final static String TMP_DIR = "D:\\Tmp\\";

    protected final static SimpleDateFormat dateTimeFormatCN = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    @BeforeEach
    public void before() {
        startCurrentTimeMillis = System.currentTimeMillis();
        log.info("start time : {}!", dateTimeFormatCN.format(new Date()));
    }

    @AfterEach
    public void after() {
        log.info("end time : {}! cost time : {} seconds", dateTimeFormatCN.format(new Date()),
                (System.currentTimeMillis() - startCurrentTimeMillis) / 1000);
    }
}
