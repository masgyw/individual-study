package cn.gyw.glearn.algorithm.limit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @date 2023/9/26
 */
class FixedWindowLimitTest {
    /**
     * 单线程
     */
    @Test
    void limitOnSingleThread() {
        FixedWindowLimit limit = new FixedWindowLimit();

        for (int i = 0; i < 100; i++) {
            boolean result = limit.limit();
            if (i < 10) {
                Assertions.assertTrue(result);
            } else {
                Assertions.assertFalse(result);
            }
        }
    }

    /**
     * 多线程
     */
    @Test
    void limitOnMultiThread() {

    }
}