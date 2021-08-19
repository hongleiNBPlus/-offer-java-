package li.剑指offer.数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 思路：1、现将数组排序
 * 2、三指针，index(0 -> num.lengrh - 2), left = index + 1, right= nums.length - 1;
 * 3、求出三指针对应数组和 temp = 0；将放入list集合中 left++；
 * 若temp 小于0 left++；
 * 若temp 大于0 right++；
 *
 * 注意：在期间有两处判断元素重复跳过步骤
 */
public class Solution {
    public static void main(String[] args) {
        int[] res = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(res));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if(nums.length < 3) return resList;

        Arrays.sort(nums);
        int temp;
        int left;
        int right;
        List<Integer> list;

        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;

            //含重复元素跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;
            while (left < right){
                temp = nums[i] + nums[left] + nums[right];
                if (temp == 0){
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resList.add(list);

                    //判断是否有重复，重复跳过
                    while (left + 1 < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                }else if (temp > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return resList;
    }
}
