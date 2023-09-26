package cn.gyw.glearn.algorithm.limit;

/**
 * 简单计数器限流算法
 *
 * @date 2023/9/26
 */
public class FixedWindowLimit {

    /**
     * 启动时间戳
     */
    private long startTime = System.currentTimeMillis();
    /**
     * 计数器
     */
    private int counter = 0;
    /**
     * 阈值
     */
    private int threshold = 10;
    /**
     * 时间窗格 单位毫秒
     */
    private long windowUnit = 1000;

    public boolean limit() {
        long now = System.currentTimeMillis();
        if ((now - startTime) > windowUnit) {
            counter = 0;
            startTime = now;
        }
        if (counter < threshold) {
            counter++;
            return true;
        }
        return false;
    }

}
