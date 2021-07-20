package li.剑指offer.数组.斐波那契数列;

import java.util.ArrayList;

/**
 * 题目：现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 */
public class Solution {
    public int Fibonacci(int n) {
        /**
         * 思路：第0项为0，第1项是1
         * 创建一个数组，斐波拉切数列的特点就是当前数是前面两个数之和
         * 根据这个特点遍历n次，将第n个元素加入数组返回即可
         */
        if(n == 0) return 0;
        if(n == 1) return 1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        int temp;
        for(int i = 2; i < n + 1; i++){
            temp = list.get(i - 1) + list.get(i - 2);
            list.add(temp);
        }
        return list.get(n);
    }
}
