package li.剑指offer.数组.下一个排列;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; //从右往左找第一个降序对(i, i + 1)
        for (int j = n - 1; i >= 0 && j >= i + 1; j--) { //如果找到了降序对，就在区间[i + 1, n)从右往左找第一个大于i的数
            if (nums[j] > nums[i]) {
                swap(nums, j, i); //交换nums[i]和区间[i + 1, n)中大于nums[i]且最接近nums[i]的数
                break;
            }
        }
        if (i >= 0) reverse(nums, i + 1); //如果非最大排列，还要对区间[i + 1, n)进行升序处理
        if (i < 0) reverse(nums, 0); //如果为最大排列，直接对整个nums进行升序处理
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start) {
        for (int l = start, r = nums.length - 1; l < r; l++, r--) {
            swap(nums, l, r);
        }
    }
}
