package li.剑指offer.数组.扑克牌顺子;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * 1. A为1，J为11，Q为12，K为13，A不能视为14
 * 2. 大、小王为 0，0可以看作任意牌
 * 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 例如：给出数据[6,0,2,0,4]
 * 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
 * 这样这五张牌在[2,6]区间连续，输出true
 * 数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 *
 * 思路:
 * 1、跳过大小王场景
 * 2、找到数组中最大值与最小值
 * 3、判断max - min < array.length;
 * 4、需要考虑是否存在重复数字（出0之外），若存在返回false;
 */
public class Solutin {
    public boolean IsContinuous(int [] numbers) {
        int min = 14;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (number == 0) continue;
            max = Math.max(max,number);
            min = Math.min(min,number);
            if (set.contains(number)) return false;
            set.add(number);
        }
        return (max - min) < numbers.length;
    }
}
