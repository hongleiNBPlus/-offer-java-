package li.剑指offer.字符串.括号序列;

import java.util.*;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 *有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 思路：借助双栈
 */

public class Solution {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid (String s) {
        // write code here
        if (s.length() == 1) return false;
        String[] strs = s.trim().split("");
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for(int i = 0; i < strs.length; i++){
            stack1.push(strs[i]);
        }

        while(!stack1.isEmpty()){
            if(stack2.isEmpty()) stack2.push(stack1.pop());

            //若")(){}",若不加这行会报栈异常
            if(stack1.isEmpty()) break;
            if(")".equals(stack2.peek()) && "(".equals(stack1.peek())){
                stack2.pop();
                stack1.pop();
            }else if("]".equals(stack2.peek()) && "[".equals(stack1.peek())){
                stack2.pop();
                stack1.pop();
            }else if("}".equals(stack2.peek()) && "{".equals(stack1.peek())){
                stack2.pop();
                stack1.pop();
            }else{
                if (!stack1.isEmpty())
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()) return true;
        else return false;
    }
}
