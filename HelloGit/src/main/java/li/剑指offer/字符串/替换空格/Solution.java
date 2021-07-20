package li.剑指offer.字符串.替换空格;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Solution {
    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(replaceSpace(s));
    }
    /*
     *将传入的字符串通过toCharArray（）生成一个char数组
     *需要用StringBuilder来拼接字符串
     *遍历这个char数组，若为空格用“%20”替换，若不为空格直接保留
     */
     private static String replaceSpace (String s) {
        char[] ch = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : ch){
            if(c == ' '){
                str.append("%20");
            }else{
                str.append(c);
            }
        }

        return str.toString();
    }
}
