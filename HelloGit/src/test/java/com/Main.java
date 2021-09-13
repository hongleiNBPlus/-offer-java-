package com;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int aAbs = Math.abs(ax - ay);
        int bAbs = Math.abs(bx - by);
        int res = Math.abs(aAbs - bAbs);
        System.out.println(res);
    }
}


