package li.剑指offer.树结构.二叉树的直径;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 解释：两结点之间的路径长度是以它们之间边的数目表示。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 */
public class Solution {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        deep(root);

        //返回二叉树左子树，右子树的最大层数之和
        return ans;
    }

    /**
     *
     * @param node 节点
     * @return 求二叉树深度
     */
    public int deep(TreeNode node){
        if (node == null) return 0;
        int l = deep(node.left);
        int r = deep(node.right);

        ans = Math.max(ans, l + r);

        return Math.max(l,r)+1;
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
