package li.剑指offer.数组.数组中出现次数超过一半的数字;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 输入：[1,2,3,2,2,2,5,4,2]
 * 返回值：2
 *
 * 解题思路：1、HashMap法，统计每个元素出现次数
 * 若某元素出现超过半数，即返回该数
 *
 * 2、投票法：算法流程:
 * 初始化： 票数统计 votes = 0 ， 众数 x；
 * 循环： 遍历数组 nums 中的每个数字 num ；
 * 当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
 * 当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
 * 返回值： 返回 x 即可；
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array){
        //投票法：
        int votes = 0;
        int x = 0;

        for(int num : array){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
