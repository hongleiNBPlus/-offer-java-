package li.剑指offer.数组.调整数组顺序使奇数位于偶数前面;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 实例：
 * 输入：[1,2,3,4]
 * 返回值：[1,3,2,4]
 *
 * 思路: 双指针
 */
public class Solution {
    public int[] reOrderArray (int[] array) {
        int l = 0;
        int r = array.length - 1;
        int[] res = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        while(l < array.length && r >= 0){
            if(array[l] % 2 == 1) res[left++] = array[l++];
            else l++;

            if(array[r] % 2 == 0) res[right--] = array[r--];
            else r--;
        }
        return res;
    }
}
