package cn.gyw.glearn.algorithm.heap;

/**
 * 场景：10亿数据取最大的1000个数
 * 假设：存储的是int 32位（4个字节）4GB的存储量
 * 内存：2G
 *
 * 应用：找出一堆数中，最大的前100，不用排序（使用小顶堆，根节点比子节点都小）
 * Created by guanyw on 2018/11/5.
 */
public class TopN {

	private int parent(int n) {
		return (n - 1) / 2;
	}

	private int left(int n) {
		return 2 * n + 1;
	}

	private int right(int n) {
		return 2 * n + 2;
	}

	// 构建Heap (取top的n个数，data[]原数组)
	private void buildHeap(int n , int[] data) {
		for (int i = 1 ; i < n ; i++) {
			int t = i;
			while (t != 0 && data[parent(t)] > data[t]) {
				int temp = data[t];
				data[t] = data[parent(t)];
				data[parent(t)] = temp;
				t = parent(t);
			}
		}
	}

	// 调整堆
	private void adjustHeap(int index, int n, int[] data) {
		if (data[index] <= data[0]) {
			return;
		}
		// 置换堆顶
		int temp = data[index];
		data[index] = data[0];
		data[0] = temp;

		int t = 0;
		while((left(t) < n && data[left(t)] < data[t])
				|| (right(t) < n && data[right(t)] < data[t])) {
			if (right(t) < n && data[right(t)] < data[left(t)]) {
				temp = data[t];
				data[t] = data[right(t)];
				data[right(t)] = temp;
				t = right(t);
			} else {
				temp = data[t];
				data[t] = data[left(t)];
				data[left(t)] = temp;
				t = left(t);
			}
		}

	}

	public void print(int[] data) {
		for (int i = 0 ; i < data.length ; i++) {
			System.out.println(data[i] + "  ");
		}
		System.out.println("----------------------");
	}

	public void findTopN(int n, int[] data) {
		// 先构造个小顶堆
		buildHeap(n, data);
		// n往后的逐个进行判断调整
		for (int i = n; i < data.length; i++) {
			adjustHeap(i, n, data);
		}
	}
}
