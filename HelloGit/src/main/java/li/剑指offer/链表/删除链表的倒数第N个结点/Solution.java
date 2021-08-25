package li.剑指offer.链表.删除链表的倒数第N个结点;

/**
 * 删除链表的倒数第N个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 解题思想：类似于找到链表倒数k个节点
 * 但需要找到不是倒数第k个节点，而是倒数第k个节点的前一个节点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode virtual = new ListNode(-999);
        ListNode quick = virtual;
        ListNode slow = virtual;
        virtual.next = head;

        for (int i = 0; i < n + 1; i++) quick = quick.next;

        while (quick != null){
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return virtual.next;
    }

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

}
