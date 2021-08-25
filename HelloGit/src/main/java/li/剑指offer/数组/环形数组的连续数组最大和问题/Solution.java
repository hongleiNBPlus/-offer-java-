package li.剑指offer.数组.环形数组的连续数组最大和问题;

/**
 * 题目：环形数组的连续数组最大和问题
 *
 * 例子：数组【1,-5,7,3,-1,8】
 * 如果不是环形数组：连续数组最大和 7 + 3 - 1 + 8 = 17;
 * 若是环形数组：连续数组最大和：7 + 3 -1 + 8 + 1 = 18;
 *
 * 解题思路：
 *  1、不考虑环形数组，只考虑普通数组最大和问题 dp[i] = Math.max(array[i], dp[i - 1])
 *  2、只考虑环形数组，不考虑普通数组最大和问题：求出普通数组的最小和问题min，
 *     然后用数组总sum - min，即为环形数组的连续数组最大和
 *  3、然后比较这两种情况最大值，即环形数组连续数组最大和
 */
public class Solution {
    public static void main(String[] args) {
        int[] res =  {1,-5,7,3,-1,8};
        int result = circleMaxValue(res);
        System.out.println(result);
    }
    public static int circleMaxValue(int[] res){
        int max = res[0];
        int min = res[0];
        int dpMax = res[0];
        int dpMin = res[0];
        int sum = res[0];
        for (int i = 1; i < res.length; i++) {
            sum += res[i];
            dpMax = Math.max(res[i], res[i] + dpMax);
            max = Math.max(max,dpMax);
            dpMin = Math.min(res[i], res[i] + dpMin);
            min = Math.min(dpMin,min);
        }

        return Math.max(max, sum-min);

    }
}
