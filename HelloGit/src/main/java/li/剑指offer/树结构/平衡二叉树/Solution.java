package li.剑指offer.树结构.平衡二叉树;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 *
 * 解题思路：
 * recur(root) 函数：
 *
 * 返回值：
 * 当节点root 左 / 右子树的深度差 ≤ 1 ：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值 +1 （max(left, right) + 1）；
 * 当节点root 左 / 右子树的深度差 > 2 ：则返回 -1 ，代表此子树不是平衡树 。
 *
 * 终止条件：
 * 当 root为空：说明越过叶节点，因此返回高度 0 ；
 * 当左（右）子树深度为 -1 ：代表此树的 左（右）子树不是平衡树，因此剪枝，直接返回 -1 ；
 *
 * IsBalanced_Solution函数：
 * 判断返回值是否为-1；当为-1时，不是平衡二叉树，当不为-1时，是平衡二叉树
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root){
        if (root == null) return 0;
        int left = recur(root.left);

        if (left == -1) return -1;

        int right = recur(root.right);

        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
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
