package cn.gyw.spring.scheduler.scheduler;

import cn.gyw.spring.scheduler.delay.DelayFlushTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component("myTaskScheduler")
public class MyTaskScheduler implements InitializingBean {

    private static final String THREAD_PREFIX = "MY_SCHEDULER";

    private TaskScheduler taskScheduler;

    public void execute(DelayFlushTask task) {
        Date runTime = new Date(System.currentTimeMillis() + task.getNextDelayTime());
        log.info("任务[{}] run at:{}", task.getIdx(),
                new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS").format(runTime));
        /*
        注意：如果任务执行30s，则最多只有4个线程执行，且释放资源后其他线程才可以执行
        会导致其他线程延迟
         */
        taskScheduler.schedule(task, runTime);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix(THREAD_PREFIX);
        scheduler.setPoolSize(4);
        // 初始化
        scheduler.initialize();
        System.out.println(scheduler.getScheduledThreadPoolExecutor());
        this.taskScheduler = scheduler;

        System.out.println(">>> 初始化：" + scheduler);
    }
}
