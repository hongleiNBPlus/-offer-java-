package li.剑指offer.链表.从尾到头打印链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 输入：{67,0,24,58}
 * 返回值：[58,24,0,67]
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //解题思路；利用栈来实现
        /*
         *依次遍历链表，将链表中的元素加入到栈中
         *链表遍历完成后，依次取出栈中元素，即等于尾到头打印链表
         */
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        ListNode temp = listNode;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
