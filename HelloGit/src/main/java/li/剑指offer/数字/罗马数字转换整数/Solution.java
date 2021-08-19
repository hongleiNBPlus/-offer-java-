package li.剑指offer.数字.罗马数字转换整数;

import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 解题思路：
 *      从右到左依次遍历罗马数字，当前一个字符对象的罗马数字大于后一个字符对象的罗马数字时，采用减法 ：比如 IV 就用 V - I
 *      当前一个字符对应的罗马数字小于后一个字符对应的罗马数字，采用加法，比如VI 就用 V + I
 */
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder strb = new StringBuilder();
        char[] ch = s.toCharArray();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len = ch.length;
        int res = 0;
        res += map.get(ch[len - 1]);
        for(int i = len - 2; i >=0; i--){
            if(map.get(ch[i]) < map.get(ch[i+1])){
                res -= map.get(ch[i]);
            }else {
                res += map.get(ch[i]);
            }
        }
        return res;
    }
}
