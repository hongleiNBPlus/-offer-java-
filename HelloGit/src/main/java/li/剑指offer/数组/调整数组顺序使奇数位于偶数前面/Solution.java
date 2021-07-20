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
 * 思路：利用两个队列，将奇数放入一个队列，将偶数放入一个队列
 * 遍历两个队列将奇数放前面偶数放后面
 */
public class Solution {
    public int[] reOrderArray (int[] array) {
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 ==1 ){
                list1.add(array[i]);
            }else {
                list2.add(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(!list1.isEmpty()){
                array[i] = list1.poll();
            }else {
                array[i] = list2.poll();
            }
        }
        return array;
    }
}
