package com;



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int p = Integer.parseInt(split[1]);
        int q = Integer.parseInt(split[2]);


        String[] lines = sc.nextLine().split(" ");
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(res);

        int[] pValue = new int[n];
        pValue[pValue.length - 1] = 100;
        int result = 0;
        if (pValue.length == 1 ){
            if (((double) ((pValue[0] * p) + (res[0] * q)) / 100) > 60){
                System.out.println(1);
            }else System.out.println(0);
        } else {
            for (int i = pValue.length - 2; i >= 0; i--) {
                if(res[i] == res[i + 1]) pValue[i] = pValue[i+1];
                else pValue[i] = pValue[i + 1] - 1;
            }

            for (int i = 0; i < res.length; i++) {
                double v = (double) ((pValue[i] * p) + (res[i] * q)) / 100;
                if(v >= 60) result++;
            }
        }
        System.out.println(result);
    }
}