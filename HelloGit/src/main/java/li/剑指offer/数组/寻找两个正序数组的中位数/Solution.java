package li.剑指offer.数组.寻找两个正序数组的中位数;

/**
 * 题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 *
 * 实例：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 解题思路：
 * 1、特殊情况，两数组都为空，返回0
 * 2、将两数组合并成一个大数组，然后二分找中位数
 *    若大数组长度为奇数 返回res[len / 2]
 *    若大数组长度为偶数，返回(double)(res[len / 2] + res[len / 2 - 1]) / 2
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        int left = 0, right = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int temp = 0;
        int[] resNum = new int[len1 + len2];
        while (left < len1 && right < len2){
            if(nums1[left] < nums2[right]) resNum[temp++] = nums1[left++];
            else resNum[temp++] = nums2[right++];
        }

        while (left < len1) resNum[temp++] = nums1[left++];
        while (right < len2) resNum[temp++] = nums2[right++];

        return minValue(resNum);
    }

    private static double minValue(int[] resNum) {
        int len = resNum.length;
        if(resNum.length % 2 == 1) return resNum[len / 2];
        //必须转成double类型，要不是会被舍去小数部分
        else return (double)(resNum[len / 2] + resNum[len / 2 - 1]) / 2;
    }
}
