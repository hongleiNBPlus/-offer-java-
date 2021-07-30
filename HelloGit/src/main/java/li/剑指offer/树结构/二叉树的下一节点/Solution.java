package li.剑指offer.树结构.二叉树的下一节点;

/**
 * 题目：二叉树的下一节点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 *
 * 解题思路：1、首先判断该节点是否含有右子树，如何有右子树，找到该右子树的最左子节点返回
 *          2、若没有右子树
 *              2.1 判断该节点是否为它父节点的左子节点，如果是，则返回父节点
 *              2.2 若该节点为它父节点的右节点，向上遍历：即node = node.father 继续返回2.1
 *          3、若都不满足1,2；可能是最后一个节点，返回null
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1、首先判断该节点是否含有右子树，如何有右子树，找到该右子树的最左子节点返回
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null) node = node.left;
            return node;
        }else {
            /*
             * 2、若没有右子树
             *   2.1 判断该节点是否为它父节点的左子节点，如果是，则返回父节点
             *   2.2 若该节点为它父节点的右节点，向上遍历：即node = node.father 继续返回2.1
             */
            while (pNode.father != null){
                TreeLinkNode father = pNode.father;
                if (pNode == father.left) return father;
                pNode = pNode.father;
            }
        }
        return null;
    }


    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode father = null;  //指向父节点

        public TreeLinkNode(int val){
            this.val = val;
        }
    }
}
