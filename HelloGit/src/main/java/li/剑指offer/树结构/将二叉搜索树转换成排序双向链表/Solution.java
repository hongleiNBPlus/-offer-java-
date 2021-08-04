package li.剑指offer.树结构.将二叉搜索树转换成排序双向链表;


import java.util.LinkedList;
import java.util.List;

/**
 * 将二叉搜索树转换成有序的双向链表
 *
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        /**
         * 思路1:将二叉树中序遍历放入数组中，然后遍历数组转换成排序二叉树
         */
        List<TreeNode> list = new LinkedList<>();
        dfs(pRootOfTree,list);
        TreeNode root = list.get(0);
        TreeNode preNode;
        TreeNode nextNode;
        for (int i = 1; i < list.size(); i++) {
            preNode = list.get(i - 1);
            nextNode = list.get(i);
            preNode.right = nextNode;
            nextNode.left = preNode;
        }
        return root;
    }

    public void dfs(TreeNode root, List<TreeNode> list){
        if (root == null) return;

        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }

    private class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
