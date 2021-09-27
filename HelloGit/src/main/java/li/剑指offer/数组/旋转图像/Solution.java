package li.剑指offer.数组.旋转图像;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 思路：先沿右上 - 左下的对角线翻转（270° + 一次镜像），
 * 再沿水平中线上下翻转（-180° + 一次镜像），可以实现顺时针 90 度的旋转效果
 *

 */
public class Solution {
    public void rotate(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        //右上左下对折
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i){
            for (int j = 0; j < nums - i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }

        //水平中线上下对折
        for (int i = 0; i < (nums >> 1); ++i){
            for (int j = 0; j < nums; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }
}
