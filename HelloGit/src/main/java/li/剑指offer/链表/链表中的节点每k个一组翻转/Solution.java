package li.剑指offer.链表.链表中的节点每k个一组翻转;

/**
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度O(1)
 *
 * 给定的链表是1->2->3->4->5
 * 对于k=2, 你应该返回 2->1->4->3->5
 * 对于k=3, 你应该返回 3->2->1->4->5
 */
public class Solution {
    public static ListNode reverseKGroup (ListNode head, int k) {
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode start = virtual;
        ListNode end = virtual;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null) break;
            ListNode pre = start.next;
            ListNode last = end.next;
            end.next = null;
            start.next = reverse(pre);
            pre.next = last;
            start = pre;
            end = pre;
        }
        return virtual.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode last;
        while (cur != null){
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
        return pre;
    }

    private static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }
}
