package cn.zwy.algorithm.everyday.leetcode.medium;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/design-circular-deque/">641. 设计循环双端队列</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月15日 11:51
 */
public class CircularDeque {

    int[] deque;
    int size;
    int Front;
    int Last;

    public CircularDeque(int k) {
        deque = new int[k + 1];
        size = k + 1;
        Front =Last= 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque[Front] = value;
        Front = (Front + 1) % size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[Last] = value;
        Last = (Last + size - 1) % size;
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
        Front = (Front + size - 1) % size;
        return deque[Front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        Last = (Last + 1) % size;
        return deque[Last];
    }

    public boolean isEmpty() {
        return Front == Last;
    }

    public boolean isFull() {
        return (Last-1+size)% size == Front;
    }

    public static void main(String[] args) {
        CircularDeque circularDeque = new CircularDeque(3);
        circularDeque.insertLast(1);
        circularDeque.insertLast(2);
        circularDeque.insertFront(3);
    }

}
