package li.剑指offer.数组.旋转数组的最小数字;

/**
 * 题：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 输入：[3,4,5,1,2]
 * 返回值：1
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        /**
         * 旋转数组[3,4,5,1,2]可以分为左有序数组[3,4,5]与右有序数组[1,2]
         * 定义三个指针left,right,mid分别代表数组的最左边元素的索引，最右边元素的索引，中间元素的索引
         * 判断:若array[mid] > array[right]，那么array[mid]一定在右有序数组中，让left = mid + 1；
         * 若array[mid] < array[right]，那么array[mid]一定在左有序数组中，让right = mid；
         * 若array[mid] = array[right]，无法判断是在左有序数组还是右有序数组
         *                 //示例一 [1, 0, 1, 1, 1]:旋转点 x = 1，因此 mid = 2在右排序数组中
         *                 //示例二 [1, 1, 1, 0, 1]：旋转点 x = 3，因此 mid = 2在左排序数组中
         *                 //因此只能不停地right--来缩减数组
         * 循环判断条件是left < right
         */

        int left = 0;
        int right = array.length - 1;
        int mid;

        while(left < right){
            mid = (left + right) / 2;
            if(array[mid] < array[right]){
                right = mid;
            }else if(array[mid] > array[right]){
                left = mid + 1;
            }else {
                right--;
            }
        }
        return array[right];
    }
}
