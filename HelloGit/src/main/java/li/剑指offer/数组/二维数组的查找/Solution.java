package li.剑指offer.数组.二维数组的查找;

/**
 * 题描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 *   [1,2,8,9],
 *   [2,4,9,12],
 *   [4,7,10,13],
 *   [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * 给定 target = 3，返回 false。
 *
 * 解题思路；
 * 定义两个指针：indexA表示左下角数的x轴所对应的值； indexB表示左下角数的y轴对应的值；
 * 从二维数组的左下角元素开始遍历，当这个值大于目标值时，向上移动
 * 当这个值小于目标值时，向右移动
 */
public class Solution {
    public boolean Find(int target, int [][] array) {

        int indexA = array.length - 1;
        int indexB = 0;

        while(indexA >= 0 && indexB < array[0].length){
            if(array[indexA][indexB] > target){
                indexA--;
            }else if(array[indexA][indexB] < target){
                indexB++;
            }else {
                return true;
            }
        }
        return false;
    }
}
