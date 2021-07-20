package li.剑指offer.链表.反转链表;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 输入：{1,2,3}
 * 返回值：{3,2,1}
 *
 * 三个指针：一开始pre指向空，cur指向head，next
 * 循环遍历（判断条件cur不为空）
 * next为了保存cur的next节点（否则，翻转过程中cur与前一节点相连已达到反转效果，这时cur会与下一节点断开，
 * next作用就用来保存下一节点，防止cur没法访问下一节点）
 */
public class Solution {
    public ListNode ReverseList(ListNode head){
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
