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
        if(strs.length == 0) return "";
        int len = strs.length;
        int num = strs[0].length();
        for(int i = 0; i < num; i ++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < len; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
