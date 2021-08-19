package li.剑指offer.数组.盛最多水的容器;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：比如1与7 那么容器高为1，宽度为7的索引 - 1的索引
 * 双指针 left right
 * 若左指针的值小于右指针的值，左指针移动有可能面积增大，但右指针移动面积一定减小
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int res = 0;
        int temp;
        int right = height.length - 1;
        while (left < right){
            if(height[left] < height[right]){
                temp = height[left] * (right - left);
                left++;
            }else {
                temp = height[right] * (right - left);
                right--;
            }

            if (temp > res) res = temp;
        }
        return res;
    }
}
