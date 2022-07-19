package cn.zwy.structure.stack.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * &#064;Description:      <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">用栈实现队列</a>
 * 思路一 ： 双栈，一个辅助栈，一个队列栈
 * 1. 每次来数据，先把队列栈的数据全部 push到辅助栈，然后辅助栈加入数据 得到：
 * 添加 5进入 队列栈【4，3，2，1】 -》 辅助栈【1，2，3，4，5】 -》 队列栈【】
 * 把辅助栈数据 push 到 队列栈 得到： 队列站【5，4，3，2，1】
 * &#064;author:  zwy
 * &#064;date:  2022年07月18日 16:48
 */
public class ImplementQueueUsingStacks {

    private final Deque<Integer> stackP;

    private final Deque<Integer> stackT;


    public ImplementQueueUsingStacks() {
        stackP = new LinkedList<Integer>();
        stackT = new LinkedList<Integer>();
    }

    public void push(int x) {
        stackP.push(x);
    }

    public int pop() {
        if (stackT.isEmpty()){
            setStackT();
        }
        return stackT.pop();
    }

    public int peek() {
        if (stackT.isEmpty()){
            setStackT();
        }
        return stackT.peek();
    }

    public boolean empty() {
        return stackP.isEmpty() && stackT.isEmpty();
    }

    public void setStackT() {
        while (!stackP.isEmpty()) {
            stackT.push(stackP.pop());
        }
    }

    public static void main(String[] args) {

    }
}
