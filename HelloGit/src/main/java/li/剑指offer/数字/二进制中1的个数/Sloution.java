package li.剑指offer.数字.二进制中1的个数;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：每次（n & n - 1）之后 n中二进制数1的个数减1
 *
 */
public class Sloution {
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0){
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
