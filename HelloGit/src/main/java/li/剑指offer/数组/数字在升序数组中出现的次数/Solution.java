package li.剑指offer.数组.数字在升序数组中出现的次数;

import java.util.HashMap;

/**
 * 题目：统计一个数字在升序数组中出现的次数。
 * 输入：[1,2,3,3,3,3,4,5],3
 * 返回值：4
 *
 * 解题思路：利用HashMap
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k){
        int temp = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }else {
                temp = hashMap.get(array[i]);
                hashMap.replace(array[i],++temp);
            }
        }

        return hashMap.getOrDefault(k,0);
    }
}
