package li.剑指offer.链表.链表中环的入口结点;

/**
 * 链表中环的入口结点;若有环则返回环的头节点；否则返回null
 *
 * 解题思路:
 * 1、首先判断是否有环；若没有环，直接返回null
 * 2、若有环，则快慢指针第一次相遇后，让慢指针返回到链表的头节点，此时让快慢指针每次移动一个节点
 * 当快慢指针第二次相遇时，此时相遇在环的头节点，返回慢指针即可
 *
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        //定义快慢指针
        ListNode slow = pHead;
        ListNode quick = pHead;

        while (true){
            //若满足这个if条件证明该链表是无环的
            if (quick == null || quick.next == null) return null;

            slow = slow.next;
            quick = quick.next.next;

            //slow == quick 证明快慢指针相遇，链表有环
            if (slow == quick) break;
        }

        //当快慢指针相遇后，将快指针重新指向pHead，此时让快慢指针每次移动一个节点
        // 当快慢指针第二次相遇时，此时相遇在环的头节点，返回慢指针即可
        quick = pHead;

        while (quick != slow){
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode{
        int val;
        ListNode next = null;

        public  ListNode(int val){
            this.val = val;
        }
    }
}
