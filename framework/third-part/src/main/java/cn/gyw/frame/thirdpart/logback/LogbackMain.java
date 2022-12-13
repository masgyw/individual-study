package cn.gyw.frame.thirdpart.logback;

import cn.gyw.frame.thirdpart.logback.parent.LoggerParent;
import cn.gyw.frame.thirdpart.logback.parent.sub.LoggerSub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author
 * @desc
 * @createdTime 2022/5/27
 */
public class LogbackMain {

    private static final Logger log = LoggerFactory.getLogger("logtest");

    public static void main(String[] args) {
        // logger 父子包继承问题
        LoggerParent loggerParent = new LoggerParent();
        LoggerSub loggerSub = new LoggerSub();

        // loggerSub.info();
        loggerSub.debug();


        // MDC.put("taskCode", "1123");
        // log.info("1234412323");
        // MDC.clear();


    }

}
