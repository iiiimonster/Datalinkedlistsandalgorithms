package cn.zwy.algorithm.everyday.leetcode.medium;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/design-circular-deque/">641. 设计循环双端队列</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月15日 11:51
 */
public class MyCircularDeque {

    int[] deque;
    int size;
    int Front;
    int Last;

    public MyCircularDeque(int k) {
        deque = new int[k + 1];
        size = k + 1;
        Front = Last = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque[Front] = value;
        Front = (Front + 1) % size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Last = (Last + size - 1) % size;
        deque[Last] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Front = (Front + size - 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Last = (Last + 1) % size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque[(Front + size - 1) % size];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[Last];
    }

    public boolean isEmpty() {
        return Front == Last;
    }

    public boolean isFull() {
        return (Front + 1) % size == Last;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
    }

}
