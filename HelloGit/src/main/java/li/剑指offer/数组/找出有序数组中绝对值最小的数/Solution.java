package li.剑指offer.数组.找出有序数组中绝对值最小的数;

/**
 * 题目：找出有序数组绝对值最小的数（有序数组里面有负数）
 *
 * 解题思路：数组array
 * 1、判断该数组第一个元素是否为正值或0，即array[0] >= 0，由于是有序数组，那么绝对值最小的数就是一个元素
 * 2、若不满足情况1，判断该数组最后一个元素是否为负值或者为0，
 *    即array[array.length - 1] <= 0, 由于是有序数组，那么绝对值最小的数就是最后一个元素
 * 3、若不满足上述情况，采用二分法
 *    求出mid = array.length / 2,
 *    1、若 array[mid] > 0, 判断array[mid - 1]是否小于等于0，
 *    若成立，比较array[mid]，array[mid - 1]的绝对值值，返回最小值；若不成立，向左继续二分。
 *    2、若 array[mid] < 0, 判断array[mid + 1]是否大于等于0，
 *    若成立，比较array[mid]，array[mid + 1]的绝对值值，返回最小值；若不成立，向右继续二分。
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {};
        int res = selectAbsMinNum(array);
        System.out.println(res);
    }
    private static int selectAbsMinNum(int[] array){
        if (array.length == 0) return -999;
        int len = array.length;
        int l = 0;
        if (array[l] >= 0) return Math.abs(array[l]);
        if (array[len - 1] <= 0) return Math.abs(array[len - 1]);
        while (true){
            int mid = (len + l) / 2;
            if (array[mid] > 0){
                if (array[mid - 1] <= 0){
                    return Math.min(Math.abs(array[mid]),Math.abs(array[mid - 1]));
                }else {
                    len = mid;
                }
            }else if (array[mid] < 0){
                if (array[mid] >= 0){
                    return Math.min(Math.abs(array[mid]),Math.abs(array[mid + 1]));
                }else{
                    l = mid + 1;
                }
            }else {
                return array[mid];
            }
        }
    }
}
