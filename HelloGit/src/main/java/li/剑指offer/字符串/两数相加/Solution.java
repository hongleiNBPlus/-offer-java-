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
        String res = addStrings("99999999999999999999999999999999", "2222222222");
        System.out.println(res);
    }
    public static String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int flag = 0;
        int temp1;
        int temp2;
        StringBuilder strb = new StringBuilder();

        while (index1 >= 0 || index2 >= 0){
            temp1 = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            temp2 = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;

            strb.append((temp1 + temp2 + flag) % 10);

            flag = (temp1 + temp2 + flag) / 10;
        }

        if(flag == 1) strb.append(flag);

        return strb.reverse().toString();
    }
}
