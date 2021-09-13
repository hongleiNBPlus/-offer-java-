package li.剑指offer.链表.合并k个有序链表;

import java.util.ArrayList;

/**
 * 合并k个已排序的链表并将其作为一个已排序的链表返回
 *
 * 思路：合并k个有序链表就是采用分治的思想，将K个链表两两合并；
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }
        return merge(lists, 0, lists.size()-1);
    }
    // 分治
    private ListNode merge(ArrayList<ListNode> lists, int left, int right){
        if(left == right){
            return lists.get(left);
        }
        int mid = left + (right - left ) / 2;
        ListNode node1 = merge(lists, left , mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return mergeTwoList(node1, node2);
    }
    // 合并两个有序链表
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dumpy.next;
    }

    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }
}
