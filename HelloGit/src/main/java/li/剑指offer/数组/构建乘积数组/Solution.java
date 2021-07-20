package li.剑指offer.数组.构建乘积数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 *
 * 输入：[1,2,3,4,5]
 * 返回值：[120,60,40,30,24]
 *
 * 思路：分两个数组，左边数组当前元素的左边数组（不包含该元素），右边数组为当前元素的右边数组（不包含该元素）
 * 例如：【1,2,3,4,5,6】 B[3]的左数组【1,2,3】 右数组【5,6】
 * 然后左右数组相乘
 */
public class Solution {
    public int[] multiply(int[] A) {
        if(A == null || A.length < 1) return null;
        int len = A.length;

        int[] left = new int[len];//不包含该元素的左边数组
        int[] right = new int[len];//不包含该元素的右边数组

        left[0] = 1;
        for (int i = 1; i < len; i++) {   //左边数组的动态规划
            left[i] = left[i-1] * A[i - 1];
        }

        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {  //右边数组的动态规划
            right[i] = right[i + 1] * A[i + 1];
        }

        for (int i = 0; i < len; i++) {
            A[i] = left[i] * right[i];
        }

        return A;
    }
}
