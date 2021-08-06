package li.剑指offer.数字.丑数;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：输入一个数n，求出第n个丑数
 *
 * 解释：什么是丑数？  某个数只包含2,3,5质子的数为丑数 ， 特别指出1是第一个丑数
 * 比如，4,6,8,9这种是丑数，而14这种不是，因为包含质子7
 *
 * 动态规划问题：
 * 解题思路：比如求第7个丑数，我们需要创建一个大小为7的数组
 * 依次从小到大将丑数加入到数组中
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int[] dp = new int[index];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //这个条件可以判断每次加入是当前最小丑数
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[index - 1];
    }
}
