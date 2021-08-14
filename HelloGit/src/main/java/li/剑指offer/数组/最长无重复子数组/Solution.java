package li.剑指offer.数组.最长无重复子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * 输入：[2,2,3,4,3]
 * 返回值：3
 * 说明：[2,3,4]是最长子数组
 *
 * 解题思路：利用hashMap与双指针
 */
public class Solution {
    public int maxLength (int[] arr) {
        int res = 0;
        int start = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            //代表存在重复值，并更新重复值起始点
            if (map.containsKey(arr[end])) start = Math.max(start, map.get(arr[end]) + 1);

            //更新子数组的长度
            res = Math.max(res,end - start + 1);
            map.put(arr[end],end);
        }
        return res;
    }
}
