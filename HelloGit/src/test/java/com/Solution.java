package com;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] res = {1,2,3,4,5};
        double[] co = {2.0, 3.0, 1.0, 4.0, 2.0};
        double[] co1 = {0.2, 0.1, 0.2, 0.1, 0.4};
        int[] ints = calculateUserList(res, co, co1, 9.5);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] calculateUserList (int[] userIdList, double[] costList, double[] conversionList, double avg_cost) {
        // write code here
        Map<Double,Integer> map = new TreeMap<>();
        for(int i = 0; i < userIdList.length; i++){
            if (!map.containsKey(costList[i])) map.put(costList[i],userIdList[i]);
            else{
                double value = costList[i] + 0.00001;
                map.put(value,userIdList[i]);
            }
        }

        double res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (Double aDouble : map.keySet()) {
            res += aDouble;
            if (res <= avg_cost) list.add(map.get(aDouble));
            else break;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }

}
