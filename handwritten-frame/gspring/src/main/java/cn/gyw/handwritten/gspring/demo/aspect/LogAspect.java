package cn.gyw.handwritten.gspring.demo.aspect;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切面
 *
 */
public class LogAspect {

	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	private ThreadLocal<LocalDateTime> dtTreadLocal;
	
	public void before() {
		LocalDateTime startTime = LocalDateTime.now();
		dtTreadLocal.set(startTime);
		LOG.info("Start time at :{}", dtf.format(startTime));
	}

	public void after() {
		LocalDateTime startTime = dtTreadLocal.get();
		LOG.info("Invoke success, cost :{} ms", Duration.between(startTime, LocalDateTime.now()).toMillis());
	}

	public void afterThrowing() {

	}

}
