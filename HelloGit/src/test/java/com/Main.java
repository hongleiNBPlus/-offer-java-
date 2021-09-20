package com;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{
            add(5);
            add(3);
            add(10);
            add(7);
            add(-99);
            add(99);
            add(15);
        }};

//        for (int i = list.size() - 1; i >= 0; i--) {
////            if (list.get(i) < 10) list.remove(i);
////        }
////
////        System.out.println(list);

        list.removeIf(i -> i < 10);
        System.out.println(list);
    }
}

 
