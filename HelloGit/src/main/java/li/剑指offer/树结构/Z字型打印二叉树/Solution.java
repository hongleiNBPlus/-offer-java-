package li.剑指offer.树结构.Z字型打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Z字型打印二叉树
 * 类似于层序遍历 = 层序遍历 + 双向链表
 * 若为奇数层，需要正序添加LinkedList中，用list.addLast(list.add)
 * 若为偶数层，需要反序添加LinkedList中，用list.addFirst
 * 其他步骤和层序遍历相同
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            size++;
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if (size % 2 == 0){
                    linkedList.addFirst(node.val);
                }else {
                    linkedList.addLast(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(linkedList);
        }
        return resList;
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
