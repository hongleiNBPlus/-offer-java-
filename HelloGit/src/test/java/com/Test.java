package com;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
       String[] strs = {"1", "-1", "10", "-999"};
       int[] res = new int[strs.length];
       for (int i = 0; i < strs.length; i++){
           res[i] = Integer.valueOf(strs[i]);
       }
        System.out.println(Arrays.toString(res));
    }
}


