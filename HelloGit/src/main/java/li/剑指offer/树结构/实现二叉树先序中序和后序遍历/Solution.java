package li.剑指offer.树结构.实现二叉树先序中序和后序遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：分别按照二叉树先序，中序和后序打印所有的节点
 * 输入：{1,2,3}
 * 返回值：[[1,2,3],[2,1,3],[2,3,1]]
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int[][] ints = threeOrders(treeNode1);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    public static int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preOrder(root,pre);
        inOrder(root,in);
        postOrder(root,post);
        int[][] res = new int[3][pre.size()];
        for(int i = 0; i < pre.size(); i++){
            res[0][i] = pre.get(i);
        }
        for(int i = 0; i < pre.size(); i++){
            res[1][i] = in.get(i);
        }
        for(int i = 0; i < pre.size(); i++){
            res[2][i] = post.get(i);
        }
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> pre){
        if(root == null) return;
        pre.add(root.val);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }

    public static void inOrder(TreeNode root, List<Integer> in){
        if(root == null) return;
        inOrder(root.left,in);
        in.add(root.val);
        inOrder(root.right,in);
    }

    public static void postOrder(TreeNode root, List<Integer> post){
        if(root == null) return;
        postOrder(root.left,post);
        postOrder(root.right,post);
        post.add(root.val);
    }

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public  TreeNode(int val){
            this.val = val;
        }
    }
}
