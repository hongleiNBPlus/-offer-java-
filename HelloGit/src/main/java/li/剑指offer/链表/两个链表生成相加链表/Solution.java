package li.剑指offer.链表.两个链表生成相加链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 *
 * 思路：利用双栈
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode head2 = new ListNode(9);
    }
    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Deque<ListNode> dq1 = new LinkedList<>();
        Deque<ListNode> dq2 = new LinkedList<>();
        Deque<ListNode> dq;

        while (head1 != null){
            dq1.addFirst(head1);
            head1 = head1.next;
        }

        while (head2 != null){
            dq2.addFirst(head2);
            head2 = head2.next;
        }
        int n1 = 0;
        int n2 = 0;
        int temp = 0;

        dq = dq1.size() > dq2.size() ? dq1 : dq2;
        ListNode node = dq.getFirst();
        while (!dq.isEmpty()){
            node = dq.getFirst();
            n1 = dq1.size() > 0 ? dq1.removeFirst().val : 0;
            n2 = dq2.size() > 0 ? dq2.removeFirst().val : 0;
            node.val = (n1 + n2 + temp) % 10;
            temp = (n1 + n2 + temp) / 10;
        }

        if (temp == 1){
            ListNode head = new ListNode(1);
            head.next = node;
            node = head;
        }
        return node;
    }

    private static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
}
