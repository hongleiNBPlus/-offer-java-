package li.剑指offer.树结构.二叉树的前序遍历_迭代法;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历---迭代法
 *
 * 解题思路：借助于栈
 * 前序遍历的思路: 输出顺序：根节点-->左子节点--> 右子节点
 *
 */
public class Solution {
    public List<Integer> preorderTraversal(ListNode root){
        List<Integer> resList = new LinkedList<>();
        if (root != null) return resList;
        Stack<ListNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            resList.add(node.val);

            //栈的特点：先进后出，先压入右子节点，后压入左子节点
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return resList;
    }

    class ListNode{
        int val;
        ListNode left = null;
        ListNode right = null;
        public ListNode(int val){
            this.val = val;
        }
    }
}
