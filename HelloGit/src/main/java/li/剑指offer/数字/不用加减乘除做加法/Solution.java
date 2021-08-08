package li.剑指offer.数字.不用加减乘除做加法;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 解题思路：
 */
public class Solution {
    public int Add(int num1,int num2) {
        while (num2 != 0){
            int c = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;
    }
}
