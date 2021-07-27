package li.剑指offer.数组.快速排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] num = {7,4,3,8};
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(int[] num, int left, int right){
        if (left >= right) return;

        int i = left;
        int j = right;
        int value = num[left];

        while (i < j){

            while (i < j && num[j] >= value) j--;

            num[i] = num[j];

            while (i < j && num[i] <= value) i++;

            num[j] = num[i];
        }

        num[i] = value;

        quickSort(num,left,i-1);
        quickSort(num,j+1,right);
    }
}
