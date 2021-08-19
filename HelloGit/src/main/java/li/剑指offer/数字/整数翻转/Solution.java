package li.剑指offer.数字.整数翻转;

/**
 * 题目：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 */
public class Solution {
    public int reverse(int x) {
        int res = 0;
        int maxV = Integer.MAX_VALUE / 10;
        int minV = Integer.MIN_VALUE / 10;
        while (x != 0){
            int temp = x % 10;

            //判断是否越界
            if(res > maxV  || (res == maxV && temp > 7)) return 0;
            if(res < minV || (res == minV && temp < -8)) return 0;

            x = x / 10;
            res = res * 10 + temp;
        }
        return res;
    }
}
