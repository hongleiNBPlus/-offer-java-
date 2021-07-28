package li.剑指offer.字符串.字符流中第一个不重复的字符;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 输入："google"
 * 返回值："ggg#ll"
 *
 * 解题思路：为啥用LinkedHashMap数据先进先出，而HashMap是无序的
 */
public class Solution {

    Map<Character,Integer> hashMap = new LinkedHashMap<>();

    /**
     * @param ch 每次输入一个字符
     */
    public void Insert(char ch){
        if (!hashMap.containsKey(ch)){
            hashMap.put(ch,1);
        }else {
            hashMap.put(ch,hashMap.get(ch) + 1);
        }
    }

    /**
     * @return 每次输入一个字符后，返回第一个不重复的字符
     */
    public char FirstAppearingOnce(){
        for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
            if(map.getValue() == 1){
                return map.getKey();
            }
        }
        return '#';
    }
}
