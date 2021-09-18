package li.剑指offer.数组.字符串出现次数的TopK问题;

import java.util.*;

/**
 * 给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
 * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
 * 对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
 * 比如"ah1x"小于"ahb"，"231"<”32“
 * 字符仅包含数字和字母
 *
 * 输入：["a","b","c","b"],2
 * 返回值：[["b","2"],["a","1"]]
 * 说明：
 * "b"出现了2次，记["b","2"]，"a"与"c"各出现1次，但是a字典序在c前面，记["a","1"]，
 * 最后返回[["b","2"],["a","1"]]
 */
public class Solution {
    public String[][] topKstrings (String[] strings, int k) {
        //1、统计结果
        String[][] res = new String[k][2];
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) map.put(strings[i],1);
            else map.put(strings[i], map.get(strings[i]) + 1);
        }

        //2、封装成Node方便排序
        List<Node> list = new ArrayList<>();
        Set<String> strings1 = map.keySet();
        for (String key : strings1) {
            list.add(new Node(key,map.get(key)));
        }

        //3、自定义排序方法
        list.sort((o1, o2) -> {
            if (o1.val != o2.val) return o2.val - o1.val;
            else return o1.str.compareTo(o2.str);
        });

        //4、获取TopK
        for (int i = 0; i < k; i++) {
            Node node = list.get(i);
            res[i][0] = node.str;
            res[i][1] = String.valueOf(node.val);
        }
        return res;
    }

    public class Node{
        String str;
        int val;
        Node(String str, int val){
            this.str = str;
            this.val = val;
        }
    }
}
