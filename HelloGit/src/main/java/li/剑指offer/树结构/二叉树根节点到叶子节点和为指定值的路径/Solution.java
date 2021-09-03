package li.剑指offer.树结构.二叉树根节点到叶子节点和为指定值的路径;

import java.util.ArrayList;

/**
 * 给定一个二叉树和一个值sum，请找出所有的根节点到叶子节点的节点值之和等于sum的路径，
 */
public class Solution {
    ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        findPath(root,sum);
        return resList;
    }

    public void findPath(TreeNode node, int sum){
        if(node == null) return;
        list.add(node.val);
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null)
            resList.add(new ArrayList<>(list));
        findPath(node.left,sum);
        findPath(node.right,sum);
        list.remove(list.size() - 1);
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
