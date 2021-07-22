package li.剑指offer.树结构.二叉树中和为某一值的路径;

import java.util.ArrayList;

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
