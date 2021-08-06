package li.剑指offer.数字.变态跳台阶;

/**
 * 题目：变态跳台阶问题
 * 每次可以跳1-k，问k个台阶有多少种跳法
 */
public class Solution {
    public int jumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;

        int a = 1;
        int b = 2;
        for (int i = 2; i <= target; i++) {
            b = a * 2;
            a = b;
        }
        return a;
    }
}
