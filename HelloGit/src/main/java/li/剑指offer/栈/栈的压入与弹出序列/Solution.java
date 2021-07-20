package li.剑指offer.栈.栈的压入与弹出序列;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 输入：[1,2,3,4,5],[4,3,5,1,2]
 * 返回值：false
 *
 * 解题思路：
 * 1、借助辅助栈,用来存放pushA数组里的元素
 * 2、定义指正index为popA数组的指针
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //TODO 1、借助辅助栈,用来存放pushA数组里的元素
        //     2、定义指正index为popA数组的指针
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        //TODO 3、遍历pushA数组，将元素加入辅助栈中
        for(int num : pushA){
            stack.push(num);

            // TODO 4、判断指针指向的元素是否与栈顶元素相同，若相同，则将该元素从栈中取出，index++;
            while (!stack.isEmpty() && popA[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        //TODO 5、当栈为空，返回true
        return stack.isEmpty();
    }
}
