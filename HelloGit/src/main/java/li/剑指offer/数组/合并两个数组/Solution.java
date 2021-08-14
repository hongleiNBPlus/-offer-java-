package li.剑指offer.数组.合并两个数组;

/**
 * 给出一个整数数组A和有序的整数数组B，请将数组B合并到数组A中，变成一个有序的升序数组
 * A: [4,5,6,0,0,0]，m=3
 * B: [1,2,3]，n=3
 * 合并过后A为:
 * A: [1,2,3,4,5,6]
 *
 * 思路：从后往前向A中插入数据
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (indexA >= 0 && indexB >=0)
            A[index--] = A[indexA] > B[indexB] ?  A[indexA--] : B[indexB--];

        //为什么只遍历indexB >= 0而不需要遍历indexA >= 0;若indexB < 0,证明已经把B数组所有元素加到A数组中
        while (indexB >= 0) A[index--] = B[indexB--];
    }
}
