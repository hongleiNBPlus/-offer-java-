package li.剑指offer.树结构.二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历。先输出父节点，然后向左遍历，然后向右遍历
 */
public class Solution {
    public List<Integer> preorderTraversal(ListNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;

    }

    void preOrder(ListNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right,list);
    }
}

class ListNode{
    int val;
    ListNode left;
    ListNode right;

    public ListNode(int val){
        this.val  = val;
    }
}
