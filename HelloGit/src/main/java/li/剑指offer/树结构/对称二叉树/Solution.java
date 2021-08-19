package li.剑指offer.树结构.对称二叉树;

/**
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 解题思路：
 * 1、若pRoot为空，返回true
 * 2、若pRoot不为空
 *      终止条件： 1： l 与 r 同时越过叶子节点，返回true
 *               2:   l 与  r 没有同时越过叶子节点，返回false
 *               3：  l.val != r.val ,返回false
 * 3、递归recur(l.left, r.right) 与 recur（l.right,r.left)
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || recur(pRoot.left, pRoot.right);
    }

    boolean recur(TreeNode l, TreeNode r){
        if (l == null && r == null) return true;

        if (l == null || r == null || l.val != r.val) return false;

        return recur(l.left, r.right) && recur(l.right,r.left);
    }


    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
