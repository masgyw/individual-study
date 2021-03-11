package cn.gyw.glearn.algorithm.sort;

/**
 * 归并排序
 * <p>
 * 时间复杂度：O(nlogn)
 */
public class MergeSorter implements ISorter {
    @Override
    public void sort(int[] data) {
        mergeSort(data, data.length);
    }

    /**
     * 自底向上的归并排序
     * 不需要递归
     *
     * @param arr
     * @param n
     */
    private void mergeSort(int[] arr, int n) {
        int[] aux = new int[n];
        System.arraycopy(arr, 0, aux, 0, arr.length);

        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), aux);
            }
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int aux[]) {
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }

        }
    }

    /**
     * 递归
     * 时间复杂度 O(nlogn)
     * @param arr
     * @param l
     * @param r
     */
    public void mergeSort(int arr[], int l, int r) {
        if (l > r) {
            return;
        }
        int mid = l + (r - l ) / 2;
        mergeSort(arr, l , mid);
        mergeSort(arr, mid + 1, r);
        //merge(arr, l, mid, r);
    }

    @Override
    public int getRunCnt() {
        return 0;
    }
}
