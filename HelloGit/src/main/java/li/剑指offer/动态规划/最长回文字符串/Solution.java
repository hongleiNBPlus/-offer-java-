package li.剑指offer.动态规划.最长回文字符串;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 思路：动态规划
 * 若dp[i][j] 其中i,j分别代表左索引，右索引
 * dp[i][j] 表示字符串从i->j字符串是否为回文字符串
 * 首先 dp[i][i]=true 表示单个字符，必为回文字符
 * 若判断dp[i][j]是否为回文字符串需要两个条件
 * 1、ch[i] == ch[j]是否成立
 * 2、j - i < 2 或者  dp[i + 1][j - 1]是否为true
 */

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int sum = 0;
        String result = "";
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (ch[i] == ch[j] && (j - i < 2 || dp[i+1][j - 1])) dp[i][j] = true;
                if(dp[i][j]){
                    if(j - i + 1 > sum){
                        sum = j - i + 1;
                        result = s.substring(i,j+1);
                    }

                }
            }
        }
        return result;
    }
}
