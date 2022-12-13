package cn.gyw.spring.scheduler.delay;

import cn.gyw.spring.scheduler.scheduler.MyTaskScheduler;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @desc
 * @createdTime 2022/7/28
 */
@ToString
@Setter
@Getter
@Slf4j
@Scope(scopeName = "prototype")
@Component
public class DelayFlushTask implements Runnable {

    @Resource
    private MyTaskScheduler taskScheduler;

    private Integer idx;

    /**
     * 延迟时间 ms
     */
    private long nextDelayTime;
    /**
     * 刷新次数
     */
    private int refreshCnt;

    /**
     * 延迟配置
     */
    private DelayConfig delayConfig;

    @Override
    public void run() {
        log.info("任务[{}]开始执行延迟任务", idx);
        try {
            // 模拟任务执行耗时
            TimeUnit.SECONDS.sleep(1L);

            // 模拟下次延迟的判断逻辑
            this.refreshCnt++;
            Optional<DelayConfig.CycleConfig> optional =
                    this.delayConfig.getCycleConfig().stream().filter(cfg -> cfg.getCnt() >= refreshCnt)
                            .findFirst();
            if (optional.isPresent()) {
                this.idx = this.refreshCnt;
                this.nextDelayTime = optional.get().getDelay() * 1000L;
                taskScheduler.execute(this);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
