package li.剑指offer.数组.最接近的三数之和;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 实例：输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 *
 * 思路：1、现将数组进行排序
 * 2、三指针 i (0 -> nums.length - 2), left = i+1, right = num.length - 1;
 * 3、求这三个指针对用数组元素之和 temp
 * 4、判断： 若 temp - target > 0, 证明三个数之和大于target，应该将right--;
 *          若 temp - target < 0, 证明三个数之和小于target，应该将left++;
 *          若 temp - target == 0， 直接返回temp即可
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left;
        int right;
        int temp;
        int j; //表示temp 与 taget的间隔
        int res = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right){
                temp = nums[i] + nums[left] + nums[right];
                j = Math.abs(temp - target);
                if(j < res){
                    res = j;
                    result = temp;
                }

                if(temp - target > 0) right--;
                else if (temp - target < 0) left++;
                else return temp;
            }
        }
        return result;
    }
}
