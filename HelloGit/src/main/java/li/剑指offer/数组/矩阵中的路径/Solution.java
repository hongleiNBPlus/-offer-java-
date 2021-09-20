package li.剑指offer.数组.矩阵中的路径;

/**
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class Solution {
    public boolean hasPath (char[][] matrix, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //判断一矩阵任何位置为起点能否找到该路径
                if (dfs(matrix,chars,i,j,0)) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param matrix 矩阵
     * @param chars 单词所组成字符数组
     * @param i 当前字符对矩阵x轴值
     * @param j 当前字符对应y轴值
     * @param k 字符数组索引值
     * @return 以当前字符能否找到单词路径
     */
    private boolean dfs(char[][] matrix, char[] chars, int i, int j, int k) {

        //考虑i, j的越界情况以及当前矩阵值是否与当前字符数组值相同
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != chars[k])
            return false;
        if (k == chars.length - 1) return true;

        //将当前矩阵值为空，防止二次到相同节点
        matrix[i][j] = '\0';

        //判断情况右移 -- 左移 -- 下移 -- 上移
        boolean res = dfs(matrix, chars,i + 1, j,k + 1) || dfs(matrix, chars, i - 1, j, k + 1) ||
                dfs(matrix, chars, i, j + 1, k + 1) || dfs(matrix, chars, i, j - 1, k + 1);

        //恢复该节点值
        matrix[i][j] = chars[k];
        return res;
    }
}
