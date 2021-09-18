package li.剑指offer.链表.单链表的排序;

/**
 * 给定一个无序单链表，实现单链表的排序(按升序排序)。
 *
 *输入: [1,3,2,4,5]
 * 返回值: {1,2,3,4,5}
 */
public class Solution {
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        while (node.next != null) {
            ListNode temp = node.next;
            while (temp != null) {
                if (temp.val < node.val) {
                    int val = temp.val;
                    temp.val = node.val;
                    node.val = val;
                }
                temp = temp.next;
            }
            node = node.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
