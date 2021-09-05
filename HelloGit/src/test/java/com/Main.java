package com;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] line = sc.nextLine().trim().toCharArray();
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String flag = "YES";
                char[] res = sc.nextLine().trim().toCharArray();
                for (int j = 0; j < line.length; j++) {
                    if (line[j] == 'X' && res[j] == '1') {
                        flag = "NO";
                        break;
                    }
                }
                System.out.println(flag);
            }
        }
    }
}