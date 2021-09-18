package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(";");
        if (line.length == 1) System.out.println(line[0].split(",")[3]);
        else {
            if (line[0].length() == 0) System.out.println(line[1].split(",")[3]);
            else {
                String[] split1 = line[0].split(",");
                String[] split2 = line[1].split(",");
                int len = split1.length + split2.length;
                if (len < 3) System.out.println(-1);
                String[] res = new String[len];
                int l = 0, r = 0, index = 0;
                while (l < split1.length && r < split2.length){
                    int left = Integer.valueOf(split1[l]);
                    int right = Integer.valueOf(split1[l]);
                    if (left < right){
                        res[index++] = split1[l++];
                    }else {
                        res[index++] = split1[r++];
                    }
                    if (index == 3)break;
                }

                while (l < split1.length){
                    res[index++] = split1[l++];
                    if (index == 3) break;
                }

                while (r < split2.length){
                    res[index++] = split1[r++];
                    if (index == 3) break;
                }

                System.out.println(res[3]);
            }
        }
    }
}
