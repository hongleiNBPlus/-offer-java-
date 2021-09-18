package li.剑指offer.链表.删除链表中重复的结点;

import java.util.HashMap;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 *
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode virtual = new ListNode(-999);
        virtual.next = head;

        ListNode cur = virtual;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return virtual.next;
    }

    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
