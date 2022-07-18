package cn.zwy.structure.stack.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/min-stack/">最小栈</a> <BR/>
 * &#064;author:  zwy <BR/>
 * &#064;date:  2022年07月18日 14:58 <BR/>
 */
public class MinStack {

    private Deque stack;
    private Deque minStack;


    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 在添加的时候获取辅助栈的顶部数据和传入参数对比 <BR/>
     * 实际上辅助栈的高度是一样的 <BR/>
     *
     * @param val 传参
     */
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min((Integer) minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) minStack.peek();
    }
}
