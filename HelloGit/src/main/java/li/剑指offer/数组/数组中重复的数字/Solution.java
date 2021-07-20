package li.剑指offer.数组.数组中重复的数字;

import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任一一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。
 * 存在不合法的输入的话输出-1
 *
 * 示例:输入：
 * [2,3,1,0,2,5,3]
 * 返回值：2
 *
 * 思路：用HashSet，将每个元素加入hashset中，若hashset的长度不变证明数字重复
 */
public class Solution {
    public int duplicate (int[] numbers){

        if(numbers == null || numbers.length ==0) return -1;
        HashSet<Integer> hashSet = new HashSet<>();
        int len = 0;
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            hashSet.add(numbers[i]);
            if(len == hashSet.size()){
                res = numbers[i];
                break;
            }
            len++;
        }

        if(numbers.length == hashSet.size()){
            return -1;
        }

        return res;
    }
}
