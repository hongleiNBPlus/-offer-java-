package li.剑指offer.数组.和为S的两个数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。
 *
 * 输入：[1,2,4,7,11,15],15
 * 返回值：[4,11]
 *
 * 解题思路：HashMap
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,6,7,11,15};
        ArrayList<Integer> list = FindNumbersWithSum(array, 100);
        System.out.println(list);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int value;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            temp = sum - array[i];
            if(!map.containsKey(temp)) map.put(array[i],i);
            else {
                value = array[i] * temp;
                if(value > res){
                    res = value;
                    list.clear();
                    list.add(array[i]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
