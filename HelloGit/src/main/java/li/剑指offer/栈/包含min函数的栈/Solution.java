package li.剑指offer.栈.包含min函数的栈;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
 * 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 * 示例:
 * 输入:    ["PSH -1","PSH 2","MIN","TOP","POP","PSH 1","TOP","MIN"]
 * 输出:    -1,2,1,-1
 * 解析:
 * "PSH-1"表示将-1压入栈中，栈中元素为-1
 * "PSH2"表示将2压入栈中，栈中元素为2，-1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 * "TOP"表示获取栈顶元素==>返回2
 * "POP"表示弹出栈顶元素，弹出2，栈中元素为-1
 * "PSH-1"表示将1压入栈中，栈中元素为1，-1
 * "TOP"表示获取栈顶元素==>返回1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 *
 */
public class Solution {

    // TODO 解题思路:
       // TODO 1、生成两个栈，一个栈res用来存放正常数据压入或取出操作，另一个栈min用存放最小值


    //正常压入或取出数据的栈
    Stack<Integer> resStack = new Stack<>();

    //用来存放最小值的栈
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        // TODO 2 每次压入数据都需要判断该数据是否为最小值，若为最小值直接压入minStack中，
        //  若不是最小值，则将minStack最上面（resStack中的最小值）的值压入minStack中
        // 例如 ["PSH -1","PSH 2","PSH 1"]
        //resStack为[-1,2,1] 而 minStack为[-1,-1,-1]
        if (minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
        resStack.push(node);
    }

    public void pop() {
        resStack.pop();
        minStack.pop();
    }

    public int top() {
        return resStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
