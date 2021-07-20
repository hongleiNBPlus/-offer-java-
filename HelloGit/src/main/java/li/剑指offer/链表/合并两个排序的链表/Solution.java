package li.剑指offer.链表.合并两个排序的链表;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 输入：{1,3,5},{2,4,6}
 * 返回值：{1,2,3,4,5,6}
 *
 * 解题思路：生成一个虚拟头节点;还有个指针temp（为合并链表的指针）
 * 依次比较两个链表的节点，将值小的链表节点连接到虚拟节点
 */
public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode virtual = new ListNode(0);
        ListNode temp = virtual;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        temp.next = list1 != null ? list1 : list2;

        return virtual.next;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
