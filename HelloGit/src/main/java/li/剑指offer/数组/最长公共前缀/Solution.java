package li.剑指offer.数组.最长公共前缀;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder strb = new StringBuilder();
        String res = strs[0];
        boolean flag = true;
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() < res.length()) res = strs[i];
        }

        for (int j = 0; j < res.length(); j++) {
            char c = strs[0].charAt(j);
            for (int k = 1; k < strs.length; k++) {
                if(strs[k].charAt(j) != c) flag = false;
            }

            if (flag) strb.append(c);
            else break;
        }
        return strb.toString();
    }
}
