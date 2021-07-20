package li.剑指offer.链表.判断链表是否有环;

/**
 * 判断一个链表是否环
 *
 * 思路：快慢指针
 * 慢指针一开始指向头节点；块指针一开始指向头节点
 * 快慢指正同时移动，慢指针每次移动一步，快指针每次移动两步
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        // TODO 定义快慢指针
        ListNode slow = head;
        ListNode quick = head;

        while (true){
            //当quick为空或quick.next为空都证明无环；若不判断可能出现空指针异常
            if (quick == null || quick.next == null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;

            if(quick == slow) break;
        }

        return true;
    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }
}
