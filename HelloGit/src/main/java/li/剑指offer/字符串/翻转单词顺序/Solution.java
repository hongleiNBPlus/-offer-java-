package li.剑指offer.字符串.翻转单词顺序;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 例子：输入: "the sky is blue"
 *      输出: "blue is sky the"
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *String.trim()可以去除首尾空格
 * 将字符串按空格切分，然后从后往前依次遍历，达到翻转单词顺序
 */
public class Solution {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(ReverseSentence(s));
    }
    public static String ReverseSentence(String str){
        String[] strs = str.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(!strs[i].equals(" ")){
                res.append(strs[i]).append(" "); // 将单词拼接至 StringBuilder
            }
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}
