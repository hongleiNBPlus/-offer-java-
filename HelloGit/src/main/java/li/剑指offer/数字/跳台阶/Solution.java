package li.剑指offer.数字.跳台阶;

/**
 * 题目：跳台阶问题
 * 每次可以调一步或者两步，问k个台阶有多少种跳法
 *
 * 斐波那契数列相同思路，后一个数是前两个数之和
 */
public class Solution {
    public int jumpFloor(int target) {
//        //1、递归解法
//        if (target == 1) return 1;
//        if (target == 2) return 2;
//        return jumpFloor(target - 1) + jumpFloor(target - 2);

        //2、动态规划法
        int a = 1, b = 1, num;
        for (int i = 0; i < target; i++){
            num = a + b;
            a = b;
            b = num;
        }
        return a;
    }
}
