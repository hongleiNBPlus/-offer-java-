package li.剑指offer.买卖股票.买卖股票的最佳时机_某天买入未来某天卖出_两次;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 思路：
 * 状态定义：dp[i][j][k] 表示在 [0, i] 区间里（状态具有前缀性质），交易进行了 j 次，
 * 并且状态为 k 时我们拥有的现金数。其中 j 和 k 的含义如下：
 * j = 0 表示没有交易发生；
 * j = 1 表示此时已经发生了 1 次买入股票的行为；
 * j = 2 表示此时已经发生了 2 次买入股票的行为。
 *
 * 即我们 人为规定 记录一次交易产生是在 买入股票 的时候。
 * k = 0 表示当前不持股；
 * k = 1 表示当前持股。
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 2 维的 0 没有意义，1 表示交易进行了 1 次，2 表示交易进行了 2 次
        // 为了使得第 2 维的数值 1 和 2 有意义，这里将第 2 维的长度设置为 3
        int[][][] dp = new int[len][3][2];

        // 理解如下初始化
        // 第 3 维规定了必须持股，因此是 -prices[0]
        dp[0][1][1] = -prices[0];
        // 还没发生的交易，持股的时候应该初始化为负无穷
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            // 转移顺序先持股，再卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]) ;
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }
}