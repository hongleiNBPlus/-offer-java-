package li.剑指offer.数组.冒泡排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {5,10,1,6,8,9,4,100,1,6,2};
        bubble(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubble(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+ 1; j < array.length; j++){
                if (array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
