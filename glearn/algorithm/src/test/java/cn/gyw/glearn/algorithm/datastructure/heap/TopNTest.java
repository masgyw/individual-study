package cn.gyw.glearn.algorithm.datastructure.heap;

import org.junit.Test;

import cn.gyw.glearn.algorithm.util.DataGenerator;

public class TopNTest {

	@Test
	public void testFindTopN() {
		int[] data = DataGenerator.generateRandomArray(1000, 0, 100_000_000);
		new TopN().findTopN(10, data);
	}
}
