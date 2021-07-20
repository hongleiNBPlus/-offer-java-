package li.剑指offer.链表.删除链表中重复的结点;

import java.util.HashMap;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 解题思路：
 * 1、生成一个虚拟头节点virtual
 * 2、遍历链表，将链表的val作为key，相同节点出现次数作为value，放hashMap中
 * 3、将hashMap的值1的创建val相同的节点，连接到虚拟最终链表中
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        //1、生成最终链表的虚拟头节点
        ListNode virtual = new ListNode(0);
        ListNode index = virtual;

        //2、遍历链表，用hashMap统计相同节点出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode temp = pHead;
        while (temp != null){
            if (!map.containsKey(temp.val)){
                map.put(temp.val,1);
            }else {
                map.put(temp.val, map.get(temp.val) + 1);
            }
            temp = temp.next;
        }

        //3、再次遍历链表，创建与map中为1的key相同的节点
        temp = pHead;
        while (temp != null){
            if (map.get(temp.val) == 1){
                ListNode node = new ListNode(temp.val);
                index.next = node;
                index = index.next;
            }
            temp = temp.next;
        }
        return virtual.next;
    }

    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
