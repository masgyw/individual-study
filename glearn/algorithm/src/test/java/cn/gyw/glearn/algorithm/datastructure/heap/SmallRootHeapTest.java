package cn.gyw.glearn.algorithm.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cn.gyw.glearn.algorithm.util.DataGenerator;

public class SmallRootHeapTest {

	private static int[] data;

	@Test
	@Ignore
	public void normal() {
		SmallRootHeap heap = new SmallRootHeap(20);
		// 输出：123459786
		heap.push(8).push(5).push(9).push(4).push(2).push(3).push(6).push(7).push(1);
		while (heap.size() > 0) {
			System.out.print(heap.pop());
		}
	}

	@Test
	public void testFindTopN() {
		SmallRootHeap heap = new SmallRootHeap(10, data);
		for (int i = 0; i < 10; i++) {
			System.out.print(heap.get(i) + ", ");
		}
		System.out.println();
	}

	@Test
	public void findTonN() {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for (int i = 0; i < 10; i++) {
			queue.add(data[i]);
		}
		for (Integer i : queue) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	@Before
	public void before() {
		System.out.println("*********Method start************");
		System.out.println(">> data:" + Arrays.toString(data));
	}
	
	@After
	public void after() {
		System.out.println("*********Method end************");
	}
	
	@BeforeClass
	public static void initData() {
		data = DataGenerator.generateRandomArray(10, 0, 100);
	}
}
