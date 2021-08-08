package li.剑指offer.数字.剪绳子;

/**
 * 问题：剪绳子；
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 解题思路：将绳子按每段为3来截图，最终结果乘积会最大
 *  此时可以分为三种情况
 *  1、绳子长度n刚好是3的倍数，比如6 那么分为两段 3 x 3 = 9，是最大乘积
 *  2、绳子长度为3的倍数余1，比如7 ，此时若分3，3, 1 那么乘积3x3x1=9，而若分为3x2x2=12 > 9;
 *  3、绳子长度为3的倍数余2，比如8，此时分为3,3,2，那么3x3x2=18，此时乘积最大
 *
 *  算法流程：绳子长度为n，分为m段， n > m > 1
 *  1、若n < 3时，此时必须分两段以上，直接返回 n - 1 即可
 *  2、若n > 3时
 *      a = n / 3, b = n % 3;
 *      2.1、若 b == 0, 那么 res = 3^a
 *      2.2、若 b == 1, 那么 res = 3^a-1 * 4 (由于3*1 < 2*2)
 *      2.3 若 b == 2, 那么 res = 3^a * 2;
 *  3、返回res即可
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }
    public static int cutRope(int target) {
        int res = 0;
        if (target <= 3) return target - 1;
        else {
            int a = target / 3, b = target % 3;
            if (b == 0) res = (int) Math.pow(3,a);
            else if (b == 1) res = (int) (Math.pow(3,a-1) * 4);
            else res = (int) (Math.pow(3,a) * 2);
        }
        return res;
    }
}
