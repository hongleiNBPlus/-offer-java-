package li.剑指offer.链表.相交链表;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode l = headA;
        ListNode r = headB;
        while(l != r){
            l = l != null ? l.next : headB;
            r = r != null ? r.next : headA;
        }
        return l;
    }

    private class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
}
