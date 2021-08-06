package li.剑指offer.数字.整数中1出现的次数;

/**
 * 题目：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 *      例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
 *
 * 思路：cur为当前为的数，high为cur的高位，low为cur的低位
 * 比如2340  当前为cur = 4 ，那么高位high = 23， 低位 low = 0;
 * 1、如果cur = 0，当前位1出现次数 = high * digit
 * 2、如果cur = 1，当前位1出现次数 = high * digit + 1 + low
 * 3、如果cur = 2-9, 当前位1出现次数 = (high + 1) * digit
 *
 * 遍历n的所有位，所有位1的个数相加就是结果
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0){
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
