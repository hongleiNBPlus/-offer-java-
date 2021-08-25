package li.剑指offer.树结构.重建二叉树;

import java.util.HashMap;

/**
 * 问题描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 输入：[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值：{1,2,5,3,4,6,7}
 */
public class Solution {
    //前序遍历序列{1,2,4,7,3,5,6,8}分为[根节点，左子树，右子树]，中序遍历序列{4,7,2,1,5,3,8,6}分为[左子树，根节点，右子树]
    //思路利用HashMap；通过将in[]数组的值作为key，以及数组的索引作为value方便能快速找到某个数在in数组中的索引


    public TreeNode buildTree(int[] prerder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //三个索引分别为
        //当前根的的索引
        //递归树的左边界，即数组左边界
        //递归树的右边界，即数组右边界
        return recur(0,0,inorder.length-1,map,prerder);
    }

    TreeNode recur(int pre_root, int in_left, int in_right,HashMap<Integer,Integer> map, int[] preorder){
        if(in_left > in_right) return null;// 相等的话就是自己
        TreeNode root = new TreeNode(preorder[pre_root]);//获取root节点
        int idx = map.get(preorder[pre_root]);//获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归左子树的右边界为中序中的根节点索引-1
        root.left = recur(pre_root+1, in_left, idx-1,map,preorder);
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的右边界为中序中原来右子树的边界
        root.right = recur(pre_root + (idx - 1 - in_left + 1) + 1, idx+1, in_right,map,preorder);
        return root;

    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x;
       }
    }
}
