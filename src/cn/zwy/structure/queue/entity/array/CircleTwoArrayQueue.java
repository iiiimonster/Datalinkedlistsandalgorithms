package cn.zwy.structure.queue.entity.array;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * &#064;Description:  循环队列 二
 * &#064;author:  zwy
 * &#064;date:  2022年07月28日 15:01
 */
public class CircleTwoArrayQueue {

    /**
     * 数组队列
     */
    private int[] items;

    /**
     * 队列长度
     */
    private int size;

    /**
     * 队列头节点
     */
    private int head;

    /**
     * 队列尾节点
     */
    private int tail;


    public CircleTwoArrayQueue(int size) {
        this.size = size;
        items = new int[size];
        head = 0;
        tail = 0;
    }

    /**
     * 入队
     *
     * @param val 队列参数
     * @return 返回是否成功添加
     */
    public boolean enQueue(int val) {
        if (((tail + 1) % size) == head) {
            return false;
        }
        items[tail] = val;
        tail = ++tail % size;
        return true;
    }

    /**
     * 出队
     *
     * @return 返回队列顶端数据
     */
    public int deQueue() {
        if (head == tail) {
            return -1;
        }
        int temp = items[head];
        head = ++head  % size;
        return temp;
    }

    public static void main(String[] args) {
        CircleTwoArrayQueue circleTwoArrayQueue = new CircleTwoArrayQueue(5);

        System.out.println(circleTwoArrayQueue.enQueue(0));
        System.out.println(circleTwoArrayQueue.enQueue(1));
        System.out.println(circleTwoArrayQueue.enQueue(2));
        System.out.println(circleTwoArrayQueue.enQueue(3));
        System.out.println(circleTwoArrayQueue.enQueue(7));


        for (int i = 0; i < 4; i++) {
            System.out.println(circleTwoArrayQueue.deQueue());
        }
        System.out.println(circleTwoArrayQueue.enQueue(4));
        System.out.println(circleTwoArrayQueue.enQueue(5));
        System.out.println(circleTwoArrayQueue.enQueue(6));

        for (int i = 0; i < 3; i++) {
            System.out.println(circleTwoArrayQueue.deQueue());
        }

    }
}
