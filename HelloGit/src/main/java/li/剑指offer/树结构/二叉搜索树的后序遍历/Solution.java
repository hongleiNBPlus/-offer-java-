package li.剑指offer.树结构.二叉搜索树的后序遍历;

/**
 * 什么是二叉搜索树？满足左子树的值小于根节点；所有右子树的值大于根节点
 * 二叉搜索树的后序遍历（左子树，右子树，根节点）
 *
 *题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 *        假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 *
 * 输入：[4,8,6,12,16,14,10]
 * 返回值：true
 *
 * 解题思路：先找到左子树与右子树的边界点，判断左子树的值是否全部小于根节点
 *         所有右子树的节点全部大于根节点
 *         然后递归操作左子树与右子树
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return recur(sequence, 0, sequence.length - 1);
    }

    private boolean recur(int[] sequence, int i, int j) {
        if (sequence.length == 0) return false;
        if (i >= j) return true;
        int p = i;
        while (sequence[p] < sequence[j]) p++;
        int m = p;
        while (sequence[p] > sequence[j]) p++;

        return p == j && recur(sequence,i,m-1) && recur(sequence,m,j-1);
    }
}
