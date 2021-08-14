package com;

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ch = str.trim().toCharArray();
        int len = ch.length;
        double res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : ch){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c) + 1);
            }
        }
        for(Character kc : map.keySet()){
            int value = map.get(kc);
            double p = (double)value / len;
            res += -p * (Math.log(p) / Math.log(2));
        }
        String s = String.valueOf(res);
        int l = s.length() - s.indexOf(".");
        if (l <= 7){
            System.out.println(res);
        }else {
            System.out.println(String.format("%.7f",res));
        }

    }
}
