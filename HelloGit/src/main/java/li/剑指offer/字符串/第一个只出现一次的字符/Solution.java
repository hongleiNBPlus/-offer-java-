package li.剑指offer.字符串.第一个只出现一次的字符;

import java.util.HashMap;

/**
 * 在一个字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1
 *
 * 输入："google"
 * 返回值：4
 *
 * 解题思路：HashMap将char作为key，char出现次数作为value
 * 1、遍历依次char数组，将char数组所有元素以及出现次数加入hashmap中
 * 2、在遍历依次char数组，找出第一个只出现一次的char元素，并返回他的位置
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] ch = str.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int temp;
        int res = -1;

        for(char c : ch){
            if(!hashMap.containsKey(c)){
                hashMap.put(c,1);
            }else {
                temp = hashMap.get(c);
                hashMap.replace(c,++temp);
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if(hashMap.get(ch[i]) == 1){
                res = i;
                break;
            }
        }
        return  res;
    }
}
