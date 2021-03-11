package cn.gyw.glearn.algorithm.sort;

/**
 * 快速排序
 * 对冒泡排序算法的一种改进
 * <p>
 * 通过一趟排序，将一组数据分割为独立的两个部分，其中一部分的数据比另一部分的所有数据都要小
 * 然后再按此方法对两部分数据，以同样的方式分割，直至序列有序
 * <p>
 * 时间复杂度：
 */
public class QuickSorter implements ISorter {

    @Override
    public void sort(int[] data) {
       // 写法一
       // qsort(0, data.length - 1, data);

        // 写法二

    }

    private int[] qsort(int start, int end, int[] data) {
        int pivot = data[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && data[j] > pivot) {
                j--;
            }
            while (i < j && data[i] < pivot) {
                i++;
            }
            if (i < j && data[i] == data[j]) {
                i++;
            } else {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }

        if (i - 1 > start) {
            data = qsort(start, i - 1, data);
        }
        if (j + 1 < end) {
            data = qsort(j + 1, end, data);
        }
        return data;
    }


    /**
     * 快速排序
     * @param data
     * @param low
     * @param high
     */
    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivot = data[low],
                    i = low,
                    j = high;
            while (i < j) {
                while (i < j && data[j] >= pivot) { // 从右向左
                    j --;
                }
                if (i < j) {
                    data[i ++] = data[j];
                }

                while (i <j && data[i] < pivot) { // 从左到右，找第一个大的数
                    i ++;
                }
                if (i < j) {
                    data[j --] = data[i];
                }
            }
            data[i] = pivot;
            quickSort(data, low, i - 1);
            quickSort(data, i + 1, high);
        }
    }

    /**
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     *   大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     *   小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     *   等于 arr[R] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    private int[] partition(int[] arr, int low, int high) {
        int pivot = arr[0];
        int less = low -1;

        return new int[0];
    }

    /**
     * 交换数组两下标的位置
     * @param data 数组
     * @param i
     * @param j
     */
    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @Override
    public int getRunCnt() {
        return 0;
    }
}
