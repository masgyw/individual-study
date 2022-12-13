package cn.gyw.corejava.util;

import java.util.concurrent.TimeUnit;

/**
 * @date 2022/8/4
 */
public final class SleepHelper {

    /**
     * 休眠 ms
     *
     * @param ms 毫秒数
     */
    public static void sleep(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private SleepHelper() {}
}
