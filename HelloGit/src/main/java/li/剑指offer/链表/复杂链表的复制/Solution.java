package li.剑指offer.链表.复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 解题思路：创建一个map来存放原始节点为key，复制原始节点为value的kv值
 * 1、首先遍历原始链表，复制原始节点的每个节点
 * 2、根据原始节点的next域与random域指向，复制节点以相同的形式指向
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        //创建一个map来存放原始节点为key，复制原始节点为value
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode temp = pHead;

        //复制与原始链表相同的节点，放入map中
        while (temp != null){
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }

        //将temp重新赋值，重新遍历
        temp = pHead;

        //根据原始链表节点的next与random指向，指定复制节点next与random指向
        while (temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(pHead);
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
