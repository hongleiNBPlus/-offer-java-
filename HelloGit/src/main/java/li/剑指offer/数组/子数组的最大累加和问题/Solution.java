package li.剑指offer.数组.子数组的最大累加和问题;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 */
public class Solution {
    public int maxsumofSubarray (int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] += Math.max(arr[i - 1],0);
            res = Math.max(res,arr[i]);
        }
        return res;
    }
}
