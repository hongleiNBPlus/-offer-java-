package li.剑指offer.树结构.二叉树的镜像;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 比如：    源二叉树
 *             8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *
 *         镜像二叉树
 *             8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 *
 * 思路 循环结束条件：stack为空
 * 1：借助辅助栈
 * 2、将根节点放入栈中，如果根节点的左节点不为空，放入栈中；如果根节点的右节点不为空，放入栈中
 * 3、交换节点的左右节点
 *
 * 比如，上述二叉树为例：一开始【8】
 * 取出栈中第一个元素8 【】
 * 判断8的左右节点是否存在 【6,10】
 * 交换左右节点  此时二叉树为
 *               8
 *             /  \
 *            10   6
 *           / \  / \
 *          9 11 5  7
 * 取出下一个元素 10
 * 判断10左右节点是否为空【6，9，11】
 * 交换10的左右节点，此时
 *                  8
 *                /  \
 *              10   6
 *             / \  / \
 *            11 9 5  7
 * 重复上面操作..........;直到栈为空
 */
public class Solution {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(pRoot);

        TreeNode temp;
        TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);

            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return pRoot;
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
