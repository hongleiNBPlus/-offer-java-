package li.剑指offer.数字.求1到n之和;

/**
 * 题目：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 解题思路：利用 && 与 || 的阻塞来结束递归
 *
 */
public class Solution {
    private static int res = 0;
    public static void main(String[] args) {
        System.out.println(Sum_Solution(1));
    }

    private static int Sum_Solution(int n) {
        boolean x = n > 1 && Sum_Solution(n - 1) > 0;
        res += n;
        return res;
    }
}
