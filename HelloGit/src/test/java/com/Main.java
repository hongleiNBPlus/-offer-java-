package com;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }

        int maxV = 0;
        for (int i = 0; i < res.length; i++) {
            Math.max(maxV,res[i]);
        }

        System.out.println(maxV);
    }
}

 
