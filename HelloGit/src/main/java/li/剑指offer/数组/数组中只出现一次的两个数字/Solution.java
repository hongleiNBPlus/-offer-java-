package li.剑指offer.数组.数组中只出现一次的两个数字;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目：数组中只出现一次的两个数字
 *
 * 解题思路：借助HaspMap，key为数组中的值，value为出现次数
 */
public class Solution {
    public static void main(String[] args) {
        int[] res = {1,2,3,4,5,1,2,3,4,6};
        int[] ints = FindNumsAppearOnce(res);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] FindNumsAppearOnce (int[] array) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = 0;
        for(int i = 0; i < array.length; i++){
            num = array[i];
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        int n = 0;
        for(int j = 0; j < array.length; j++){
            if(map.get(array[j]) == 1){
                res[n] = array[j];
                n++;
            }
        }
        return res;
    }
}
