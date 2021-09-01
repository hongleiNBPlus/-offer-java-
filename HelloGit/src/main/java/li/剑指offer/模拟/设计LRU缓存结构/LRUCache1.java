package li.剑指offer.模拟.设计LRU缓存结构;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 *
 * 提示:
 * 1.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * 2.当缓存的大小超过K时，移除最不经常使用的记录。
 * 3.输入一个二维数组与K，二维数组每一维有2个或者3个数字，第1个数字为opt，第2，3个数字为key，value
 *    若opt=1，接下来两个整数key, value，表示set(key, value)
 *    若opt=2，接下来一个整数key，表示get(key)，若key未出现过或已被移除，则返回-1
 *    对于每个opt=2，输出一个答案
 * 4.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 * 用例:
 * 输入：[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 返回值：[1,-1]
 * 说明：
 * [1,1,1]，第一个1表示opt=1，要set(1,1)，即将(1,1)插入缓存，缓存是{"1"=1}
 * [1,2,2]，第一个1表示opt=1，要set(2,2)，即将(2,2)插入缓存，缓存是{"1"=1,"2"=2}
 * [1,3,2]，第一个1表示opt=1，要set(3,2)，即将(3,2)插入缓存，缓存是{"1"=1,"2"=2,"3"=2}
 * [2,1]，第一个2表示opt=2，要get(1)，返回是[1]，因为get(1)操作，缓存更新，缓存是{"2"=2,"3"=2,"1"=1}
 * [1,4,4]，第一个1表示opt=1，要set(4,4)，即将(4,4)插入缓存，但是缓存已经达到最大容量3，移除最不经常使用的{"2"=2}，插入{"4"=4}，缓存是{"3"=2,"1"=1,"4"=4}
 * [2,2]，第一个2表示opt=2，要get(2)，查找不到，返回是[1,-1]
 */

public class LRUCache1 {
    int k;
    Map<Integer,Integer> map;
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < operators.length; i++){
            if(operators[i][0] == 1) set(operators[i][1],operators[i][2]);
            else if(operators[i][0] == 2){
                int num = get(operators[i][1]);
                list.add(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        if(map.size() > k) map.remove(map.entrySet().iterator().next().getKey());
    }
}
