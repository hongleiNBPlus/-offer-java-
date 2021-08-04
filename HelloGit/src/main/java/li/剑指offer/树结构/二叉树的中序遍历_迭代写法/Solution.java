package li.剑指offer.树结构.二叉树的中序遍历_迭代写法;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历——迭代写法
 *
 * 思路：借助栈,
 *
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> resList = new LinkedList<>();
        if(root == null) return resList;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        //因为要先输出最左子叶节点，需要加上判断条件cur != null;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            //第一次pop的节点最左子叶节点，后面都是非子叶节点（父节点）
            TreeNode node = stack.pop();
            resList.add(node.val);

            //判断取出节点是否存在右子节点，将叶子节点赋给当前节点
            if (node.right != null) cur = node.right;
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
