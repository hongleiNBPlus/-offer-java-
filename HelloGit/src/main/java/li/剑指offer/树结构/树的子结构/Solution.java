package li.剑指offer.树结构.树的子结构;

/**
 * 需求：树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 输入：{8,8,#,9,#,2,#,5},{8,9,#,2}
 * 输出：true
 */
public class Solution {
    /**
     * 特例处理： 当 树 root1为空 或 树 root2为空 时，直接返回 false ；
     * 返回值： 若树 B是树 root1的子结构，则必满足以下三种情况之一，因此用或 ||连接；
     * 以 节点 root1为根节点的子树 包含树 B ，对应 recur(root1, B)；
     * 树 root2是 树 root1 左子树 的子结构，对应 isSubStructure(root1.left, root2)；
     * 树 root2 是 树 root1 右子树 的子结构，对应 isSubStructure(root1.right, root2)；
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return (root1 != null && root2 != null) && (reCur(root1,root2) || HasSubtree(root1.left,root2)
                || HasSubtree(root1.right,root2));
    }

    /**
     * 终止条件：
     * 当节点 B 为空：说明树 BB已匹配完成（越过叶子节点），因此返回 true；
     * 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
     * 当节点 A和 B的值不同：说明匹配失败，返回 false ；
     * 返回值：
     * 判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left) ；
     * 判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right) ；
     * @param A 父树
     * @param B 子树
     * @return 子树属不属于父树
     */
    public boolean reCur(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;

        return reCur(A.left, B.left) && reCur(A.right, B.right);
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
