package li.剑指offer.数组.堆排序;

import java.util.Arrays;

/**
 * 堆排序
 *
 * 思路：就是将无序数组转换成大顶堆，然后将大顶堆数组的第一个元素与最后一个元素交换
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {8,84,-44,-11,25,1,5,9,1,1,1};
        dumpSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void dumpSort(int[] array){
        for (int k = array.length; k > 0; k--){
            //从第一个非子叶节点开始循环
            for (int i = k / 2 - 1; i >= 0; i--) {
                bigDump(array,i,k);
            }
            swap(array,0,k - 1);
        }
    }

    private static void swap(int[] array, int i, int len){
        int temp;
        temp = array[0];
        array[0] = array[len];
        array[len] = temp;
    }

    private static void bigDump(int[] array, int i, int len){
        int temp = array[i];
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1){
            if (k + 1 < len && array[k] < array[k + 1]){
                k++;
            }

            if (array[k] > temp){
                array[i] = array[k];
                i = k;
            }
        }
        array[i] = temp;
    }
}
