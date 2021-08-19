package li.剑指offer.字符串.Z字形变换;

import java.util.LinkedList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 最后输出："PAHNAPLSIIGYIR"
 */
public class Solution {
    public String convert(String s, int numRows) {
        //1、特例：字符串s只有单个字符或者Z字型打印行数为1
        if(s.length() < 2 || numRows == 1) return s;

        //2、将每行的字符串放到list集合中
        List<StringBuilder> list = new LinkedList<>();

        //3、遍历字符串，按Z字型将字符放入list的每行字符串中
        for(int i = 0; i < numRows; i++) list.add(new StringBuilder());
        char[] ch = s.toCharArray();
        int index = -1;
        int flag = -1;
        for(char c : ch){
            if(flag == -1){
                list.get(++index).append(c);
                if (index == numRows - 1) flag = 1;
            }else {
                list.get(--index).append(c);
                if (index == 0) flag = -1;
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder strb : list) res.append(strb);
        return res.toString();
    }
}
