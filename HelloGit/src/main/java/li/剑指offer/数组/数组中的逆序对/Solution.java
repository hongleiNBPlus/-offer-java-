package li.剑指offer.数组.数组中的逆序对;

/**
 * 题目：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 *
 * 实例：输入：[1,2,3,4,5,6,7,0]
 * 返回值：7
 *
 * 算法流程：
 * merge_sort() 归并排序与逆序对统计：
 *
 * 终止条件： 当 l≥r 时，代表子数组长度为 1 ，此时终止划分；
 * 递归划分： 计算数组中点 m ，递归划分左子数组 merge_sort(l, m) 和右子数组 merge_sort(m + 1, r) ；
 * 合并与逆序对统计：
 * 暂存数组 nums 闭区间 [i, r] 内的元素至辅助数组 tmp ；
 * 循环合并： 设置双指针 i , j 分别指向左 / 右子数组的首元素；
 * 当 i = m + 1 时： 代表左子数组已合并完，因此添加右子数组当前元素 tmp[j] ，并执行 j = j + 1 ；
 * 否则，当 j = r + 1 时： 代表右子数组已合并完，因此添加左子数组当前元素 tmp[i] ，并执行 i = i + 1 ；
 * 否则，当 tmp[i]≤tmp[j] 时： 添加左子数组当前元素 tmp[i]tmp[i] ，并执行 i = i + 1；
 * 否则（即 tmp[i] > tmp[j]）时： 添加右子数组当前元素 tmp[j]，并执行 j = j + 1；此时构成 m - i + 1个「逆序对」，统计添加至 res ；
 * 返回值： 返回直至目前的逆序对总数 res ；
 */

public class Solution {
    int res;//逆序对个数
    public int InversePairs(int [] array){
        this.res = 0;
        mergerSort(array,0,array.length-1);
        return res;
    }

    public void mergerSort(int[] array, int l, int r){
        if(l < r){
            int mid = (l + r) / 2;
            mergerSort(array,l,mid);
            mergerSort(array,mid+1,r);
            merger(array,l,r,mid);
        }
    }

    public void merger(int[] array, int left, int right, int mid){
        //[4,5,7,8,1,2,3,6]
        int[] nums = new int[right - left + 1];
        int l = left; //左数组索引
        int r = mid + 1; //右数组索引
        int index = 0; //临时数组索引
        while (l <= mid && r <= right){
            if(array[l] < array[r]){
                nums[index++] = array[l++];
            }else {
                res += (mid - l + 1);
                nums[index++] = array[r++];
            }
        }


        while (l <= mid){
            nums[index++] = array[l++];
        }

        while (r <= right){
            nums[index++] = array[r++];
        }

        //将临时数组的值复制到arr数组中
        index = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            array[tempLeft] = nums[index];
            index += 1;
            tempLeft += 1;
        }
    }
}
