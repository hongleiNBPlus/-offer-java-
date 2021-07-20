package li.剑指offer.字符串.左旋转字符串;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出（保证 K 小于等于 S 的长度）
 * 输入："abcXYZdef",3
 * 返回值： "XYZdefabc"
 *
 * 思想：队列来保存字节
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        char[] ch = str.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder strb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            queue.add(ch[i]);
        }

        for (int i = 0; i < n; i++) {
            queue.add(queue.poll());
        }

        for (int i = 0; i < ch.length; i++) {
            strb.append(queue.poll());
        }

        return strb.toString();
    }
}
