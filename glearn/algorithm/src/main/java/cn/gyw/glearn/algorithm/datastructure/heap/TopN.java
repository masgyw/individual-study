package cn.gyw.glearn.algorithm.datastructure.heap;

/**
 * 场景：10亿数据取最大的1000个数
 * 假设：存储的是int 32位（4个字节）4GB的存储量
 * 内存：2G
 *
 * 应用：找出一堆数中，最大的前100，不用排序（使用小顶堆，根节点比子节点都小）
 * Created by guanyw on 2018/11/5.
 */
public class TopN {

	// 一个完全二叉树，所以它也就可以用数组存储
	private int[] topData;
	
	private int size;
	
	public TopN(int n, int[] data) {
		this.size = n;
		this.topData = new int[this.size];
		for (int i = 0; i < size; i ++) {
			this.topData[i] = data[i];
		}
		// 堆化
		heapify();
	}
	
	// 构建Heap (取top的n个数，data[]原数组)
	private void heapify() {
		// 最后一个节点的父节点
		int lastNodeParentIndex = (size - 2) / 2;
		for (int i = lastNodeParentIndex ; i >= 0 ; i --) {
			siftDown(i);
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
	
	/**
	 * 下移
	 * 在i 的子节点中选取最小的，如果最小的，小于i，和i交换位置
	 * @param i
	 */
	public void siftDown(int i) {
		if (i > )
	}
	
	/**
	 * 上移
	 */
	public void siftUp(int i) {
		
	}

	public int[] findTopN(int n, int[] data) {
		// 先构造个小顶堆
		buildHeap(n, data);
		// n往后的逐个进行判断调整
		for (int i = n; i < data.length; i++) {
			adjustHeap(i, n, data);
		}
		return topData;
	}
	
	// 下标为 i 的结点的父节点的下标是 （i - 1）/ 2
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// 左孩子结点为 (2 * i) + 1; 
	private int left(int i) {
		return 2 * i + 1;
	}

	// 右孩子结点为 （2 * i ）+ 2
	private int right(int i) {
		return 2 * i + 2;
	}
}
