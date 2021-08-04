package li.剑指offer.数组.求出数组前k小个数;

import java.util.ArrayList;

/**
 *
 * 题目：给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 0 <= k <= input.length <= 10000
 * 0 <= input[i] <= 10000
 *
 * 解题思路：快排
 */
public class Solution {

    public static void main(String[] args) {
        int[] input = {0,5,2,6,0,1,9,4,7,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, 4);
        System.out.println(list);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (input.length == 0 || k == 0) return resList;
        quickSort(input,0,input.length - 1);
        for (int i = 0; i < k; i++) {
            resList.add(input[i]);
        }
        return resList;
    }

    private static void quickSort(int[] input, int left, int right){
        int i = left;
        int j = right;
        int value = input[left];

        while (i < j){
            while (i < j && input[j] >= value) j--;
            input[i] = input[j];

            while (i < j && input[i] <= value) i++;
            input[j] = input[i];
        }
        input[j] = value;

        if (left < i - 1) quickSort(input,left,i - 1);
        if (j + 1 < right) quickSort(input,j + 1, right);
    }
}
