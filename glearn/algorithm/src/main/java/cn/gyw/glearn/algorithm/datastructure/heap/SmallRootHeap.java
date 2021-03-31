package cn.gyw.glearn.algorithm.datastructure.heap;

import java.util.Arrays;

/**
 * 小根堆
 * 
 * 场景：10亿数据取最大的1000个数 假设：存储的是int 32位（4个字节）4GB的存储量 内存：2G
 *
 * 应用：找出一堆数中，最大的前100，不用排序（使用小顶堆，根节点比子节点都小）
 * 
 * 注意：元素大小并不是按数组下标来排序的，下图的数字对应数组的坐标 0 1 2 3 4 5 6
 */
public class SmallRootHeap {

	// 一个完全二叉树，所以它也就可以用数组存储
	private int[] inarray;

	private int size;

	public SmallRootHeap(int n) {
		this.inarray = new int[n];
	}
	
	public SmallRootHeap(int n, int[] data) {
		this.inarray = new int[n];
		System.arraycopy(data, 0, inarray, 0, n);
		// 堆化
		heapify();
	}

	// 构建Heap (取top的n个数，data[]原数组)
	private void heapify() {
		for (int i = size - 1 ; i > 0 ; i --) {
			siftUp(i);
		}
	}
	
	public int get(int index) {
		return this.inarray[index];
	}
	
	public int size() {
		return this.size;
	}
	
	// 插入
    // 每次都在最后一个插入，然后上浮到合适位置
    public SmallRootHeap push(int value) {
        inarray[size] = value;
        siftUp(size++);
        return this;
    }

    // 弹出根元素
    // 让根元素和尾元素交换，让现在的根元素下沉即可
    public int pop() {
        swap(0, --size);
        siftDown(0);
        return inarray[size];
    }

	/**
	 * 下沉：将大的元素向下移动、当删除元素时，将首位交换，弹出尾部，首部下移即可调整位置
	 * 
	 * @param i
	 */
	public void siftDown(int index) {
		int sonIndex = left(index); // 小的孩子节点
		while (sonIndex < size + 1) {
			// 比较左右孩子谁更小
			if (sonIndex + 1 < size && inarray[sonIndex + 1] < inarray[sonIndex]) { // 右孩子更小
				sonIndex++;
			}
			if (inarray[index] < inarray[sonIndex]) { // 当前节点小于孩子节点，直接退出
				break;
			} else { // 下沉
				swap(index, sonIndex);
				index = sonIndex; // 当前孩子节点开始
				sonIndex = left(index); // 计算新的左孩子节点
			}
		}
	}

	/**
	 * 上浮：将小的元素往上移动、当插入元素时，将元素插入末尾，这样上移即可调整位置
	 */
	public void siftUp(int index) {
		int parent = parent(index); // 父节点
		while (parent >= 0) {
			// 父节点小于等于当前节点，直接返回
			if (inarray[index] >= inarray[parent]) {
				break;
			} else { // 父节点大于当前节点，当前节点上移
				swap(index, parent);
				index = parent;
				parent = parent(index);
			}
		}
	}

	// 交换，传入下标
	private void swap(int index1, int index2) {
		int temp = inarray[index1];
		inarray[index1] = inarray[index2];
		inarray[index2] = temp;
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
