package li.剑指offer.字符串.回文数;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 思路：负数一律不是回文整数
 * 若为正数，将转化成StringBuilder，然后调用reverse()函数
 * 比较倒转会后与原字符串是否相同
 *
 */
public class Solution {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(10);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder strb = new StringBuilder();
        strb.append(x);
        return strb.toString().equals(strb.reverse().toString());
    }
}
