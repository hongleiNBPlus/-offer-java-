package li.剑指offer.树结构.二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * 题目:输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 思路：二叉树前序遍历+回溯
 */

public class Solution {
    ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        recur(root,target);
        return resList;

    }

    private void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            resList.add(new ArrayList<>(path));
        }
        recur(root.left,target);
        recur(root.right,target);

        //回溯过程
        path.remove(path.size() - 1);
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
