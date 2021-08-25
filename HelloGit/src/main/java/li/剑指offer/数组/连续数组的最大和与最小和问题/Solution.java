package li.剑指offer.数组.连续数组的最大和与最小和问题;

/**
 * 求联系数组最大和问题
 *
 * 例子：数组【1,-5,7,3,-1】
 * 此时连续数组的最大和为7 + 3 = 10
 *
 * 例子：数组【1,-5,7,3,-1,8】
 * 此时连续数组的最大和为7 + 3 -1 + 8= 17
 *
 * dp[i]表示数组0-i的连续数组最大和
 * 动态规划方程：dp[i] = Math.max（array[i], array[i] + d[p - 1]）;
 * 方程解释: 若dp[i - 1] < 0; 说明前i-1个连续数组之和给array[i]起负作用，然后以array[i]为启动寻找
 * 连续数组最大值
 *
 * 连续数组最小和问题就是将max函数转换成min函数
 */
public class Solution {
    public static void main(String[] args) {
        int[] res =  {1,-5,7,3,-1,8};
        int result = maxValue(res);
        System.out.println(result);
    }
    public static int maxValue(int[] res){
        if(res.length == 0) return 0;
        int max = res[0];

        int dpMax = res[0];
        for (int i = 1; i < res.length; i++) {
            dpMax = Math.max(res[i], res[i] + dpMax);
            max = Math.max(dpMax,max);
        }
        return max;
    }
}
