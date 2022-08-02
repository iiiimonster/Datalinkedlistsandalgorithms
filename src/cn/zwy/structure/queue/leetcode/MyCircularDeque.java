package cn.zwy.structure.queue.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/design-circular-deque/">设计循环双端队列</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月02日 9:44
 */
public class MyCircularDeque {


    int[] deque;
    int head;
    int tail;
    int size;


    public MyCircularDeque(int k) {
        deque = new int[k+1];
        head = 0;
        tail = 0;
        size = k+1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + size) % size;
        deque[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head +  1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + size) % size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return deque[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(tail - 1 + size) % size];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
