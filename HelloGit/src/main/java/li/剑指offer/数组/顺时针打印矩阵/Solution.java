package li.剑指offer.数组.顺时针打印矩阵;

import java.util.ArrayList;

/**
 *题目描述： 顺时针打印矩阵
 *事例：[[1,2],[3,4]]
 *返回值：[1,2,4,3]
 *
 * 算法流程：
 * 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
 * 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
 * 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
 * 根据边界打印，即将元素按顺序添加至列表 res 尾部；
 * 边界向内收缩 1 （代表已被打印）；
 * 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
 *
 * 解题思路：四个边界，左 l, 右 r, 上 up, 下 down
 * 打印方向	1. 根据边界打印	        2. 边界向内收缩	3. 是否打印完毕
 * 从左向右	左边界l ，   右边界 r	    上边界 up 加 1	是否 up > down
 * 从上向下	上边界 up ，下边界down	右边界 r 减  1	是否 l > r
 * 从右向左	右边界 r ，  左边界l	   下边界 down 减 1	是否 up > down
 * 从下向上 下边界down ，上边界t	   左边界 up 加  1	是否 l > r
 *
 *
 */

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int l = 0;
        int r = matrix[0].length - 1;

        int up = 0;
        int down = matrix.length - 1;

        ArrayList<Integer> res = new ArrayList<>();

        while (true){
            for (int i = l; i <= r; i++) {
                res.add(matrix[up][i]);
            }

            if (++up > down) break;

            for (int i = up; i <= down; i++) {
                res.add(matrix[i][r]);
            }

            if (l > --r) break;

            for (int i = r; i >= l ; i--) {
                res.add(matrix[down][i]);
            }

            if(up > --down) break;

            for (int i = down; i >= up ; i--) {
                res.add(matrix[i][l]);
            }

            if(++l > r) break;
        }
        return res;
    }
}
