package li.剑指offer.动态规划.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 思路：深度优先 + 剪枝
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs("",n,n,list);
        return list;
    }

    /**
     *
     * @param str 当前递归得到的字符串
     * @param left 当前左括号的个数
     * @param right 当前右括号的个数
     * @param list 最后返回的list集合
     */
    private static void dfs(String str, int left, int right, List<String> list) {
        if(left == 0 && right == 0){
            list.add(str);
            return;
        }

        //每次保证str字符串左括号的个数大于右括号个数，这个地方进行剪枝
        if(left > right){
            return;
        }

        if(left > 0){
            dfs(str + "(",left-1,right,list);
        }
        if (right > 0){
            dfs(str + ")",left,right-1,list);
        }
    }
}
