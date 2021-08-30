package li.剑指offer.树结构.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * BFS（广度优先搜索）的结果：一维数组【3,9,20,15,7】
 * 层序遍历的结果: 二维数组[
 *      [3],
 *      [9,20],
 *      [15,7]
 * ]
 *
 * 解题思路：BFS广度优先搜索的变种
 * 需要记住每层的节点的个数
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        List<List<Integer>> list = levelOrder(node);
        System.out.println(list);


    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            //每层节点个数
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);
            }
            resList.add(list);
        }
        return resList;
    }

    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }

    }
}
