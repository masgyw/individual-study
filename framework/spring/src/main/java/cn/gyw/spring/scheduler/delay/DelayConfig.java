package cn.gyw.spring.scheduler.delay;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @desc
 * @createdTime 2022/7/30
 */
@Data
public class DelayConfig {

    private int startDelay;

    private List<CycleConfig> cycleConfig = new ArrayList<>();

    @ToString
    @Getter
    @Setter
    public static class CycleConfig {
        /**
         * 当前区
         */
        private int cnt;
        /**
         * 延迟时间 s
         */
        private int delay;
    }
}
