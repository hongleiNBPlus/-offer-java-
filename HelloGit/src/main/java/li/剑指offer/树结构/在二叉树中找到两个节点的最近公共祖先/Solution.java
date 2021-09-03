package li.剑指offer.树结构.在二叉树中找到两个节点的最近公共祖先;

public class Solution {
    public  int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return findFather(root,o1,o2).val;
    }

    public  TreeNode findFather(TreeNode root, int o1, int o2){
        // 如果树为空，直接返回null
        // 如果 o1和o2中有等于root的值，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        if (root == null || o1 == root.val || o2 == root.val) return root;
        TreeNode left = findFather(root.left,o1,o2);
        TreeNode right = findFather(root.right,o1,o2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

     class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }
}
