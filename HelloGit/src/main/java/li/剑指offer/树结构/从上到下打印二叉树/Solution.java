package li.剑指offer.树结构.从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 将二叉树从上往下依次打印（打印在一个数组中）
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 类似于二叉树的层序遍历，这题是将所有的值放入一个数组中；
 * 而二叉树的层序遍历是将每一层放入一个数组中，将所有层数据返回
 * 两题解题思路基本相同，可以参考层序遍历
 *
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = recur(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public List<Integer> recur(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            list.add(node.val);
        }
        return list;
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
