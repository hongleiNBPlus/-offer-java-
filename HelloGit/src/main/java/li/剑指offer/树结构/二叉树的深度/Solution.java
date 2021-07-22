package li.剑指offer.树结构.二叉树的深度;

/**
 * 给定一个二叉数，返回该二叉树的深度
 *
 * 例如：给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 * 解题思路：树的深度等于 max（左子树深度 ，右子树深度）+1
 */
public class Solution {
    public int TreeDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
