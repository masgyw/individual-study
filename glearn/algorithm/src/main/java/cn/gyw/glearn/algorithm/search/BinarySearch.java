package cn.gyw.glearn.algorithm.search;

/**
 * 二分查找算法
 * <p>
 * 时间复杂度：O(logn)
 */
public class BinarySearch implements ISearch {

    @Override
    public int search(int arr[], int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return target;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归调用
     *
     * 时间复杂度O(logn)
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int search(int arr[], int l, int r, int target) {
        if (r < l) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search(arr, l, mid - 1, target);
        } else {
            return search(arr, mid + 1, r, target);
        }
    }
}
