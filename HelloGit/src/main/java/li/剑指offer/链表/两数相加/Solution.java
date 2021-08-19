package li.剑指offer.链表.两数相加;

/**
 * 题目描述：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int left;
        int right;
        int res;
        int flag = 0; //表示进位
        while (l1 != null || l2 != null){
            left = l1 != null ? l1.val : 0;
            right = l2 != null ? l2.val : 0;

            res = (left + right + flag) % 10;
            flag = (left + right + flag) / 10;

            temp.next = new ListNode(res);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag == 1) temp.next = new ListNode(1);

        return head.next;
    }


    private class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }
}
