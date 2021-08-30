package li.剑指offer.数组.数字在升序数组中出现的次数;

import java.util.HashMap;

/**
 * 题目：统计一个数字在升序数组中出现的次数。
 * 输入：[1,2,3,3,3,3,4,5],3
 * 返回值：4
 *
 * 解题思路：二分法
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k){
        return getTargetIndex(array,k) - getTargetIndex(array,k - 1);
    }

    /**
     * 获取目标值的下一个值的索引【1，2，2，2，3】 目标值为2获取返回值最后一个2的索引+1，目标值为1，返回1的索引+1
     * @param array 目标数组
     * @param target 目标值
     * @return
     */
    int getTargetIndex(int[] array, int target){
        int left = 0, right = array.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (array[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
