package cn.gyw.frame.thirdpart.logback.parent.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 * @desc
 * @createdTime 2022/5/30
 */
public class LoggerSub {

    private static final Logger log = LoggerFactory.getLogger(LoggerSub.class);

    public void info() {
        log.info("this is info log");
    }

    public void debug() {
        log.debug("this is debug log");
    }
}
