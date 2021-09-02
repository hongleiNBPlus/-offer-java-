package li.剑指offer.数组.插入排序;

import java.util.Arrays;

public class Sloution {
    public static void main(String[] args) {
        int[] arr = {5,2,2,4,9,8,6,1,0,-1,-999};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        int inserValue;
        int index;
        for (int i = 1; i < arr.length; i++) {
            inserValue = arr[i];
            index = i - 1;

            while (index >= 0 && inserValue < arr[index]){
                    arr[index + 1] = arr[index];
                    index--;
            }

            if(index + 1 != i){
                arr[index+1] = inserValue;
            }
        }
    }
}
