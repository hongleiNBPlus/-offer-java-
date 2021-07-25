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
    public String addStrings(String num1, String num2) {
        StringBuilder strb = new StringBuilder();
        int indexA = num1.length() - 1;
        int indexB = num2.length() - 1;
        int carry = 0;  //表示进位
        int temp; //两数与进位之和

        while (indexA >= 0 || indexB >= 0 ){
            int numA = indexA >= 0 ? num1.charAt(indexA) - '0' : 0;
            int numB = indexB >= 0 ? num2.charAt(indexB) - '0' : 0;

            temp = numA + numB + carry;
            carry = temp / 10; //是否有进位

            strb.append(temp % 10);

            indexA--;
            indexB--;
        }

        if (carry == 1) strb.append(carry); //判断两数相加是否有溢出

        return strb.reverse().toString();  //最后需要翻转字符串
    }
}
