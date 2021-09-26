package li.剑指offer.数组.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n; //得到num值对应的下标
            nums[x] += n;   //num-1下标位置的数+n放入nums数组中
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                //因为值是[1,n]而第一个for循环经过if判断后筛选得到
                //的是有问题的下标即从0开始但值从1，所以下面用i+1
                list.add(i + 1);//i位置上的值i+1未曾出现过
            }
        }
        return list;
    }
}
