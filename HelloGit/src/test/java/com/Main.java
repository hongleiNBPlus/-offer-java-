package com;


import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "123 = 123 and 456 = 4 or 11 = 11";
        String s1 = judge_multi_case(s);
        System.out.println(s1);
    }

    public static String judge_multi_case (String input) {
        // write code here
        String[] strs = input.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        map.put("=",0);
        map.put("and",1);
        map.put("or",2);
        map.put("(",3);
        map.put(")",4);
        Stack<String> stackF = new Stack<>();
        Stack<String> stackS = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) stackF.add(strs[i]);
            else stackS.add(strs[i]);
        }

        Stack<String> s = new Stack<>();
        while (!stackF.isEmpty()){
            String pop1 = stackF.pop();
            if (pop1.equals(")")){
                while (!stackF.peek().equals("(")){
                    String pop = stackF.pop();
                    if (pop.equals("=")){
                        if (stackS.pop().equals(stackS.pop())) s.add("true");
                        else s.add("false");
                    }else {
                        s.add(pop);
                    }
                }
                stackF.pop();
            }else if (pop1.equals("and")) s.add(pop1);
            else if (pop1.equals("or"))s.add(pop1);
            else {
                if (stackS.pop().equals(stackS.pop())) s.add("true");
                else s.add("false");
            }
        }

        Queue<Boolean> sT = new LinkedList<>();
        Stack<String> sO = new Stack<>();
        while (!s.isEmpty()){
            String pop = s.pop();
            if (pop.equals("true")) sT.add(true);
            else if (pop.equals("false")) sT.add(true);
            else sO.add(pop);
        }

        while (!sO.isEmpty()){
            boolean pop1 = sT.poll();
            boolean pop2 = sT.poll();
            String pop = sO.pop();
            if (pop.equals("or")){
                if (pop1 || pop2) sT.add(true);
                else sT.add(false);
            }else {
                if (pop1 && pop2) sT.add(true);
                else sT.add(false);
            }
        }
        if (sT.peek().equals(false)) return "false";
        else return "true";
    }
}


