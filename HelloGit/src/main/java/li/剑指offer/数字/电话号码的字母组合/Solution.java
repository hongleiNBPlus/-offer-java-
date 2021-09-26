package li.剑指offer.数字.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class Solution {
    private String[] dig = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    StringBuilder strb = new StringBuilder();

    private List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return list;
        recur(digits,0);
        return list;
    }

    //回溯函数
    private void recur(String digits, int index) {
        if(strb.length() == digits.length()){
            list.add(strb.toString());
            return;
        }

        char[] chars = dig[digits.charAt(index) - '2'].toCharArray();
        for (char c : chars) {
            strb.append(c);
            recur(digits,index+1);
            strb.deleteCharAt(strb.length() - 1);  //回溯过程
        }
    }
}
