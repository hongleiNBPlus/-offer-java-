package li.剑指offer.数组.归并排序;

import java.util.Arrays;

/**
 * 题目：归并排序
 *
 * 思路：分治算法
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,5,7,3,2,1,8,9};
        int[] res = mergerSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] mergerSort(int[] array, int left, int right){
        if (left < right){
            int mid = (right + left) / 2;
            mergerSort(array,left,mid);
            mergerSort(array,mid + 1,right);
            merge(array, left, mid, right);
        }
        return array;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int l = left, r = mid + 1;
        int[] res = new int[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right){
            if (array[l] <= array[r]){
                res[index++] = array[l++];
            } else {
                res[index++] = array[r++];
            }
        }

        while (l <= mid){
            res[index++] = array[l++];
        }
        while (r <= right){
            res[index++] = array[r++];
        }

        for (int i = 0; i < res.length; i++) {
            array[i + left] = res[i];
        }
    }
}
