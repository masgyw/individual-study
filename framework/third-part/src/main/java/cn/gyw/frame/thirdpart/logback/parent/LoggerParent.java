package cn.gyw.frame.thirdpart.logback.parent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 * @desc
 * @createdTime 2022/5/30
 */
public class LoggerParent {

    private static final Logger log = LoggerFactory.getLogger(LoggerParent.class);

    public void info() {
        log.info("this is info log");
    }
}
