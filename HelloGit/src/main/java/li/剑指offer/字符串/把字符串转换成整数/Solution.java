package li.剑指offer.字符串.把字符串转换成整数;

/**
 * 题目：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 示例：输入："+2147483647"
 *  返回值：2147483647
 *
 *  输入："-2147483647"
 *  返回值：-2147483647
 *
 *  输入："1a33"
 *  返回值：0
 *
 *  若超过Int的最大值或最小值时，输出Int的最大值和最小值
 *
 *  思路：1、删除字符串首尾空格
 *  2、符号位 ：设置一个标志位来保存这个正负号
 *  3、遇见首个非字母则立即返回
 *  4、数字字符：
 *      4.1、字符转数字：用数字字符减去'0'
 *      4.2、数字拼接：res += res * 10 + x
 *                   x = c - '0'；（c为当前字符）
 *  5、数字越界：在每轮数字拼接前，判断 res 在此轮拼接后是否超过 2147483647  bo = 2147483647 / 10 = 214748364(边界)
 *      5.1、res * 10 > bo （第一种情况）
 *      5.1 10 * res = bo and c > 7 (第二种边界情况)
 */
public class Solution {
    public static void main(String[] args) {
        int i = strToInt("-2232555");
        System.out.println(i);
    }
    public static int strToInt(String str){
        int flag = 1; //用来表示这个数的正负
        int index = 0;
        int bo = Integer.MAX_VALUE / 10; //边界值
        char[] ch = str.toCharArray();
        int res = 0;

        if (ch[0] == '-') {
            index++;
            flag = -1;
        }else if (ch[0] == '+'){
            index++;
        }

        for (int i = index; i < ch.length; i++) {
            if (ch[i] < '0' || ch[i] > '9') break;

            int temp = ch[i] - '0';

            if (res > bo || res == bo && temp > 7){
                return res = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else {
                res = res * 10 + temp;
            }

        }

        return res * flag;
    }
}