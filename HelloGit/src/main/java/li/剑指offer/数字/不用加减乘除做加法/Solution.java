package li.剑指offer.数字.不用加减乘除做加法;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 解题思路：
 * a b c d
 * 0 0 0 0
 * 0 1 1 0
 * 1 0 1 0
 * 1 1 0 1
 *
 * 1、c为无进位和 c = a ^ b;
 * 2、d为进位  d = a & b << 1; (向前进位)
 * 3、然后将 a = c;
 * 4、b = d
 * 5、循环1-4，直到进位为0
 *
 */
public class Solution {
    public static void main(String[] args) {
        int add = Add(100, 6);
        System.out.println(add);
    }
    public static int Add(int a,int b) {
        while (b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
