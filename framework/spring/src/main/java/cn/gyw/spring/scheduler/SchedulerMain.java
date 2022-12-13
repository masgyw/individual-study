package cn.gyw.spring.scheduler;

import cn.gyw.spring.scheduler.delay.DelayConfig;
import cn.gyw.spring.scheduler.delay.DelayFlushTask;
import cn.gyw.spring.scheduler.scheduler.MyTaskScheduler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;

/**
 * 定时调度启动入口
 */
public class SchedulerMain {

    public static void main(String[] args) throws IOException {
        // spring 上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-scheduler.xml");

        delayFlush(context);

        System.in.read();
    }

    /**
     * 可配置的延迟任务
     */
    private static void delayFlush(final ApplicationContext context) {
        String config = "{\"startDelay\":\"1\",\"cycleConfig\":[{\"cnt\":\"5\",\"delay\":\"3\"},{\"cnt\":\"10\",\"delay\":\"10\"},{\"cnt\":\"20\",\"delay\":\"20\"}]}";
        System.out.println(config);
        DelayConfig delayConfig = new Gson().fromJson(config, DelayConfig.class);
        System.out.println(delayConfig);

        MyTaskScheduler executor = context.getBean(MyTaskScheduler.class);

        DelayFlushTask task = context.getBean(DelayFlushTask.class);
        task.setRefreshCnt(1);
        task.setNextDelayTime(delayConfig.getStartDelay() * 1000L);
        task.setDelayConfig(delayConfig);
        executor.execute(task);
    }
}
