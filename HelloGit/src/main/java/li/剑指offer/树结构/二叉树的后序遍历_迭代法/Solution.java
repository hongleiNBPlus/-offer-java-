package li.剑指offer.树结构.二叉树的后序遍历_迭代法;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历——迭代法
 *
 * 思路：借助两个栈
 * stack1辅助节点压入stack的顺序，分别是【根节点，右子节点，左子节点】
 */
public class Solution {
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> resList = new LinkedList<>();
        if (root == null) return resList;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()){
            resList.add(stack2.pop().val);
        }
        return resList;
    }

    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
