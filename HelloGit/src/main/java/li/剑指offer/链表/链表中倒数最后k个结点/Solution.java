package li.剑指offer.链表.链表中倒数最后k个结点;


/**
 * 题目：输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 * 示列：
 * 输入：{1,2,3,4,5},1
 * 返回值：{5}
 *
 * 解题思路；先遍历链表，获取链表长度size
 * 倒数第k个，正数第size - k个
 * 遍历获取第size - k个节点即可
 *
 */
public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k){
        ListNode temp = pHead;
        ListNode res = pHead;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }


        if(size <= 0 || size < k){
            return null;
        }

        for(int i = 0; i < size - k; i++){
            res = res.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}


