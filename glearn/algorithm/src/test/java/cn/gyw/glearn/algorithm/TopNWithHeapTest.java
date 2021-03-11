package cn.gyw.glearn.algorithm;

import cn.gyw.glearn.algorithm.heap.TopN;
import org.junit.Test;

/**
 * 大小顶堆实现 Top N 的排序算法
 */
public class TopNWithHeapTest {

    @Test
    public void shouldPrintTop3() {
        TopN topN = new TopN();
        int[] intArr = new int[] {56,32,48,29,48,57,19,38,27,49,50};

        topN.findTopN(3, intArr);
        topN.print(intArr);
    }
}
