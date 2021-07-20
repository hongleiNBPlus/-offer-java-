package li.剑指offer.数组.和为S的两个数字;

import java.util.ArrayList;

/**
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。
 *
 * 输入：[1,2,4,7,11,15],15
 * 返回值：[4,11]
 *
 * 解题思路：l 左指针 r 右指针
 */

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        int temp;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = array.length - 1;

        while (l < r){
            if(array[l] + array[r] < sum){
                l++;
            }else if(array[l] + array[r] > sum){
                r--;
            }else {
                temp = array[l] * array[r];
                if(temp < res){
                    res = temp;
                    list.add(array[l]);
                    list.add(array[r]);
                }
                l++;
                r--;
            }
        }
        return list;
    }
}
