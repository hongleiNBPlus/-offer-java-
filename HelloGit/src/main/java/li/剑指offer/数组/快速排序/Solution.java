package li.剑指offer.数组.快速排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] num = {30,15,44,25,50,10,70,5,5};
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(int[] num, int left, int right){

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

        if(i == j){
            i++;
            j--;
        }

        if (left < j) quickSort(num,left,j);
        if (i < right)quickSort(num,i,right);
    }
}
