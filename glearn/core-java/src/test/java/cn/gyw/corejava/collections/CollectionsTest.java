package cn.gyw.corejava.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTest {

	/**
	 * 洗牌算法
	 */
	@Test
	public void shuffle() {
		List<Integer> list = new ArrayList<>(2);
		list.add(0);
		list.add(1);

		int zeroCount = 0;
		int oneCount = 0;
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(list);
			if (list.get(0) == 0) {
				zeroCount ++;
			} else {
				oneCount ++;
			}
		}
		System.out.println("zeroCount = " + zeroCount);
		System.out.println("oneCount = " + oneCount);
	}

	@Test
	public void list() {
		ArrayList<Object> list1 = new ArrayList<>();
		list1.get(0);
		list1.add(null);
	}

	/**
	 * HashMap 寻找数组下标的算法
	 */
	@Test
	public void hashIndex() {
		String[] arr = new String[8];
		int hashcode = 10000;
		for (int i = 0; i < 1000; i++) {
			System.out.println("bucket index :" + String.valueOf((hashcode + i) & (arr.length - 1)));
		}
	}
	
	@Test
	public void hashSetQueryByHashCode() {
		Stream<String> generator = Stream.iterate("1", i -> i + "2");

		Set<String> set = generator.limit(100).collect(Collectors.toSet());

		set.contains("12");
	}
}
