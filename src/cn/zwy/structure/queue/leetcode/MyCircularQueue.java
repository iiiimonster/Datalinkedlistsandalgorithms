package cn.zwy.structure.queue.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/design-circular-queue/">设计循环队列</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月01日 14:53
 */
public class MyCircularQueue {

    /**
     * 长度
     */
    int size;
    /**
     * 队列数组
     */
    int[] queue;
    /**
     * 队列头
     */
    int head;
    /**
     * 队列尾
     */
    int tail;


    public MyCircularQueue(int k) {
        queue = new int[k + 1];
        size = k + 1;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (++tail) % size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (++head) % size;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    /**
     * 取尾巴
     *  先加上原来的长度 再 -1 去运算
     * @return 对应数据
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(tail + size - 1) % size];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return !((tail + 1) % size == head);
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
