package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        char[] chars0 = line[0].toCharArray();
        char[] chars1 = line[1].toCharArray();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < chars1.length; i++) {
            list.add(chars1[i]);
        }

        for (char c : chars0) {
            if (!list.contains(c)){
                String s = String.valueOf(c);
                System.out.println(s);
            }
        }
    }
}
