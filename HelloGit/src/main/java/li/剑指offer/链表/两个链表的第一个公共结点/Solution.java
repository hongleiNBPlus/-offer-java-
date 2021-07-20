package li.剑指offer.链表.两个链表的第一个公共结点;

/**
 * 输入两个无环的单链表，找出它们的第一个公共结点
 * 输入：{1,2,3,6,7},{4,5,6,7}
 * 返回值：{6,7}
 * 若没有共同节点返回空
 *
 * 解题思路: 拼接两个链表 A + B 与 B + A
 * 依次比较两个拼接链表的两个节点，当两节点相同时，即找出他俩共同节点
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 =pHead2;

        while (p1 != p2){
            p1 = p1 != null ? p1.next : pHead2;
            p2 = p2 != null ? p2.next : pHead1;
        }
        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
