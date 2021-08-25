package li.剑指offer.动态规划.最长有效括号;

import java.util.Stack;


/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 例题：") |( ( ( ) ) ) | ) |( ( ) )| ( |( )| ("
 * 答案：6
 *
 * 解题思路：借助栈
 * 1、遍历字符串长度
 * 2、若第i个字符为'('时，将对应的索引放入栈中
 * 3、若第i个字符为')'时，考虑一下几种情况
 *     3.1、此时栈为空，更新起始点位置start = i + 1;
 *     3.2、此时栈不为空，取出stack顶点元素
 *          此时栈为空，更新结果长度res = max(res, i - start + 1);
 *          此时栈不为空，更新结果长度 res = max(res, i - stack.peek());
 */

public class Solution {
    public static void main(String[] args) {
        String s = ")((()))(()(((())((";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
    public static int longestValidParentheses(String s) {
        int start = 0;
        int res = 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == '(') stack.add(i);
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                    if (stack.isEmpty()) res = Math.max(res,i - start + 1);
                    else res = Math.max(res,i - stack.peek());
                }else start = i + 1;
            }
        }
        return res;
    }
}
