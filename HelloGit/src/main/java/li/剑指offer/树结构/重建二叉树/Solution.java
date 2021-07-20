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
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int[] pre;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        this.pre = pre;
        for(int i = 0; i < in.length; i++){
            hashMap.put(in[i],i);
        }
        return reCur(0, 0, in.length - 1);
    }

    //指针root指向pre数组根节点的位置；指针left指向in数组左边界，right指向in数组右边界
    // res就是pre[root]根节点在in数组中位置
    public TreeNode reCur(int root, int left, int right){
        if(left > right) return null;
        int res = hashMap.get(pre[root]);
        TreeNode rootNode = new TreeNode(pre[root]);
        rootNode.left = reCur(root + 1, left, res - 1);
        rootNode.right = reCur(res - left + root + 1, res + 1, right);

        return rootNode;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x;
       }
    }
}
