package li.剑指offer.数组.数组中只出现一次的数;

/**
 * 题目：数组中只出现一次的数（其它数出现k次）
 *
 * 1、把数字转换成二进制
 * 2、如果所有数字都出现了 3 次，那么每一列的 1 的个数就一定是 3 的倍数。
 * 之所以有的列不是 3 的倍数，就是因为只出现了 1 次的数贡献出了 1。
 * 所以所有不是 3 的倍数的列写 1，其他列写 0 ，就找到了这个出现 1 次的数。
 * （因为是对每一位进行处理，所以把数组中的数字排成一列来看）
 *

 */
public class Solution {
    public int foundOnceNumber (int[] arr, int k) {
        // 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1。
        int[] binarySum = new int[32];
        for(int i = 0; i< 32; i++){//求每个二进制位的和
            int sum = 0;
            for(int num : arr){
                sum += (num >>i & 1);//依次右移num，同1相与，计算每一位上1的个数
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i< 32; i++){
            if(binarySum[i]%k!=0){
                res += 1<<i;//左移恢复
            }
        }
        return res;
    }
}
