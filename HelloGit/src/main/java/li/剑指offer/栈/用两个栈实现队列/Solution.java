package li.剑指offer.栈.用两个栈实现队列;
import java.util.Stack;
public class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 思路：用两个栈来实现队列
     * 栈的特点就是先进后出
     * 队列的特点就是先进先出
     * 想法就是：当push数据是就讲数据压入stack1中
     * 当pop数数据时：分两种情况
     *               第一种就是：stack2为空，将stack1中数据全部移入到stack2中，然后取出stack2中的一个元素
     *               第二种就是：stack2不为空，就直接取出stack2中的一个元素
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty() && stack2.empty()){
            return -1;
        }

        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
