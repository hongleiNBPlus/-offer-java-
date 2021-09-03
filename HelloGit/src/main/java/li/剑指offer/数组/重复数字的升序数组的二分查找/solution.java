package li.剑指offer.数组.重复数字的升序数组的二分查找;

/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，
 * 如果目标值存在返回下标，否则返回 -1
 *
 * 输入：
 * [1,2,4,4,5],4
 * 返回值：2
 * 说明：从左到右，查找到第1个为4的，下标为2，返回2
 *
 * 思路：二分法，如果找到该目标值，记录下该值的索引，继续向左数组寻找最左的目标值
 */
public class solution {
    public int search (int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                index = mid;
                right = mid + 1;
            }
        }
        return index;
    }
}
