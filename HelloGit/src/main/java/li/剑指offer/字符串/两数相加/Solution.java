package li.剑指offer.字符串.两数相加;

/**
 * 两个超过long的数字相加，这两个字为字符串
 *
 * 思路：双指针 两个字符串的指针分别是indexA，indexB
 * 用carry表示进位，temp表示两位数与进位相加
 * 判断条件是遍历完最长的数字，短的数字不足补0；
 * carry = temp / 10；
 * value = temp % 10；
 * 将value拼接字符串，
 * 最后结束循环，判断是否有溢出，将溢出位拼接入字符串
 * 然后将字符串翻转，就是最终结果
 */
public class Solution {
    public static void main(String[] args) {
        String res = addStrings("99999999999999999999999999999999", "2");
        System.out.println(res);
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder strb = new StringBuilder();
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        int charry = 0; //表示进位

        int num1_temp;
        int num2_temp;

        int value;

        while (num1_index >= 0 || num2_index >= 0){
            num1_temp = num1_index >= 0 ? num1.charAt(num1_index) - '0' : 0;
            num2_temp = num2_index >= 0 ? num2.charAt(num2_index) - '0' : 0;

            value = num1_temp + num2_temp + charry;

            charry = value / 10;

            strb.append(value % 10);

            num1_index--;
            num2_index--;
        }

        if (charry == 1) strb.append(charry);

        return strb.reverse().toString();
    }
}
