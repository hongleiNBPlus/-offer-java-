package li.剑指offer.树结构.二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历。先输出父节点，然后向左遍历，然后向右遍历
 */
public class Solution {
    public List<Integer> postOrderTraversal(ListNode root){
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return list;

    }

    void postOrder(ListNode root, List<Integer> list){
        if (root == null) return;

        postOrder(root.left, list);
        postOrder(root.right,list);
        list.add(root.val);

    }

    class ListNode{
        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val){
            this.val  = val;
        }
    }
}


