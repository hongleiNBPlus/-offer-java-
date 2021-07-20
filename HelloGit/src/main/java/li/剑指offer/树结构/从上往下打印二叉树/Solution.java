package li.剑指offer.树结构.从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  从上往下打印二叉树
 *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *  输入：{5,4,#,3,#,2,#,1}
 *  返回值：[5,4,3,2,1]
 *
 *  解题思路：
 *  1、借助辅助队列
 *  2、特列情况 root为空
 *  3、循环结束条件：队列为空
 *  4、每次取出队列一个节点，将该节点值放入list集合中
 *  5、当node的左右节点不为空，依次加入队列中
 *
 *  （这题的解题思路：类似于二叉树镜像，一个借助于栈，一个借助于队列）
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // TODO 1、借助辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        //TODO 2、特列情况 root为空
        if (root == null) return list;
        queue.add(root);

        TreeNode node;
        //TODO 3、循环结束条件：队列为空
        while (!queue.isEmpty()){
            // TODO 每次取出队列一个节点，将该节点值放入list集合中
            node = queue.poll();
            list.add(node.val);

            //TODO 当node的左右节点不为空，依次加入队列中
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }
}
