package li.剑指offer.树结构.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历。先输出父节点，然后向左遍历，然后向右遍历
 */
public class Solution {
    public List<Integer> inOrderTraversal(ListNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private void inOrder(ListNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
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
