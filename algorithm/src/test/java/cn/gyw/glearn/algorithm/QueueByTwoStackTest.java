package cn.gyw.glearn.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.gyw.glearn.algorithm.stack.QueueByTwoStack;

/**
 * Created by guanyw on 2019/3/5.
 */
public class QueueByTwoStackTest {

    private QueueByTwoStack queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueByTwoStack();
        Integer[] integers = new Integer[] {3, 4, 5, 1, 2, 1};
        for (Integer integer : integers) {
            queue.add(integer);
        }
    }

    /**
     * 队列基本功能 FIFO（先进先出）
     */
    @Test
    public void shouldFIFO() {
        Assertions.assertEquals(Integer.valueOf(3), queue.poll());
        Assertions.assertEquals(Integer.valueOf(4), queue.poll());
        queue.printInnerInfo();
        queue.add(9);
        Assertions.assertEquals(Integer.valueOf(5), queue.poll());
        Assertions.assertEquals(Integer.valueOf(1), queue.poll());
        queue.printInnerInfo();
        Assertions.assertEquals(Integer.valueOf(2), queue.poll());
        Assertions.assertEquals(Integer.valueOf(1), queue.poll());
        Assertions.assertEquals(Integer.valueOf(9), queue.poll());
    }

}
