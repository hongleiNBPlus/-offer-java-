package li.剑指offer.数字.全排序1到n;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-n的全排序
 * 用递归实现：
 * 特列：n <= 0 错误情况； n == 1 返回[[1]]
 * 当 n >= 2;
 * 可以这样考虑，n个数的所有情况是  n-1个数的所有排列情况在每种情况中从前往后依次插入第n个数构成的。
 *
 *
 * 举例： n == 2 相当于向[[1]]中[1]的数组中1的前后依次加上2，得到[[1,2],[2,1]]
 * 后面依稀递归
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> recur = recur(4);
        System.out.println(recur);
        System.out.println(recur.size());
    }
    public static List<List<Integer>> recur(int n){
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> temp;
        if (n <= 0) return null;
        if (n == 1){
            temp = new ArrayList<>();
            temp.add(n);
            resList.add(temp);
        }else {
            List<List<Integer>> recurList = recur(n - 1);
            for (List<Integer> list : recurList){
                for (int i = 0; i < n; i++){
                    //保持原数组
                    List<Integer> copyList = new ArrayList<>(list);
                    copyList.add(i,n); //从左往右依次向原数组中插入数字n
                    resList.add(copyList);
                }
            }
        }
        return resList;
    }
}
