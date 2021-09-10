package com;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list;
        while (sc.hasNext()) {
            int sum = sc.nextInt();
            if (sum > 1000) sum = 1000;
            list = new LinkedList<>();
            for (int i = 0; i < sum; i++) {
                list.add(i);
            }

            int temp = 0;
            while (list.size() > 1) {
                temp += 2;
                while (temp > list.size() - 1) {
                    temp -= list.size();
                }
                list.remove(list.get(temp));
            }
            System.out.println(list.peek());
        }

    }
}


