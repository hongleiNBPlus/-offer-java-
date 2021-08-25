package li.剑指offer.数组.接雨水;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 *
 * 建议画图理解
 *
 * 思路：动态规划（填充法）
 * 1、获取数组中最大值与最大值索引值
 * 2、从左到最大值索引值遍历，dp[i] = max(dp[i - 1], height[i]);
 * 3、按从右到最大值索引值遍历；dp[i] = max(dp[i + 1],height);
 * 步骤2、3就是填充完雨水后每个柱子高度
 * 4、dp[i]总和 - height[总和] = 接收的雨水数
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        int sum = 0;
        int maxValue = 0;
        int maxIndex = 0;
        int cSum = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxValue){
                maxValue = height[i];
                maxIndex = i;
            }
            sum += height[i];
        }

        dp[0] = height[0];
        dp[maxIndex] = height[maxIndex];
        dp[n - 1] = height[n - 1];
        for (int i = 1; i < maxIndex; i++) dp[i] = Math.max(dp[i - 1], height[i]);
        for (int i = n - 2; i > maxIndex; i--) dp[i] = Math.max(dp[i+1],height[i]);

        for (int i = 0; i < n; i++) cSum += dp[i];
        return cSum - sum;
    }
}
