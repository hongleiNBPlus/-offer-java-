package li.剑指offer.树结构.二叉搜索树的第k小的节点;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k小的节点;
 * 什么是二叉搜索树？父节点的左子节点小于父节点，右子节点大于父节点
 *
 * 解题思路:
 * 二叉树的搜索树的中序遍历，将二叉搜索树的所有节点值，按从大到小排列
 * 然后再找到第k小的节点
 */
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        List<TreeNode> list = new ArrayList<>();
        recur(pRoot,list);
        if (k < 1 || k > list.size()) return null;
        return list.get(k - 1);
    }

    private void recur(TreeNode root, List<TreeNode> list){
        if (root == null) return;

        recur(root.left,list);
        list.add(root);
        recur(root.right,list);
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
