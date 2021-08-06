package li.剑指offer.链表.链表中倒数最后k个结点;

/**
 * 链表中倒数最后k个结点
 *
 * 思路：快慢指针 fast slow
 * 先让fast想走k步，然后让fast slow 同时走，当fast为空停下来，此时fast = null，
 * 由于fast与slow之间的距离一直保持在k，此时slow正好指向倒数第k个节点
 *
 * 边界考虑：需要判断k的值是否大于链表长度，若大于，返回null
 *
 *
 */

public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode quick = pHead;
        ListNode slow = pHead;

        for (int i = 0; i < k; i++) {

            //这一步就是判断k是否大于链表长度
            if (quick == null) return null;
            quick = quick.next;
        }

        while (quick != null){
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    private class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }
}


