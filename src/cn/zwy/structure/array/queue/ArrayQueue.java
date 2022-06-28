package cn.zwy.structure.array.queue;

import com.sun.org.apache.bcel.internal.generic.IFNULL;

import java.util.Scanner;

/**
 * &#064;Description:   数组实现队列
 * &#064;author:  zwy
 * &#064;date:  2022年06月28日 11:41
 */
public class ArrayQueue implements Queue {
    private int front; //头节点
    private int tail; // 尾节点
    private final int arrMaxSize; // 队列长度
    private final int[] queue; // 队列数组

    public void operate() {
        boolean flag = true;
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("输入 a (addQueue) 为添加进入队列");
            System.out.println("输入 g (getQueue) 为出队列");
            System.out.println("输入 s (show) 为查看队列所有数据");
            System.out.println("输入 h (showHead) 为查看队列头数据");
            System.out.println("输入 e (exit) 退出程序");
            key = scanner.next().charAt(0);
            switch (key) {

                    case 'a':
                        System.out.println("请输入要添加的数据:");
                        int val = scanner.nextInt();
                        try {
                            addQueue(val);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 'g':
                        try {
                            System.out.printf("出队列的数据为:%d", getQueue());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println();
                        break;
                    case 's':
                        System.out.println("查看所有数据");
                        show();
                        break;
                    case 'h':
                        showHead();
                        break;
                    case 'e':
                        flag = false;
                        break;
            }

        }
    }

    /**
     * 构造函数 创建队列
     *
     * @param arrMaxSize 最大值
     */
    public ArrayQueue(int arrMaxSize) {
        front = -1;
        tail = -1;
        this.arrMaxSize = arrMaxSize;
        queue = new int[arrMaxSize];
    }

    /**
     * 队列已满
     */
    public void isFUll() {
        if (tail == arrMaxSize - 1) {
            throw new RuntimeException("队列已经满了");
        }
    }

    /**
     * 队列是否为空
     */
    public void isNull() {
        if (front == tail) {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * 添加队列数据
     *
     * @param var 添加的数据
     */
    public void addQueue(int var) {
        isFUll();
        queue[++tail] = var;
    }

    /**
     * 出队列
     *
     * @return 队列数据
     */
    public int getQueue() {
        isNull();
        ++front;
        return queue[front];
    }

    /**
     * 查看队列所有数据
     */
    public void show() {
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("arr[%d] = %d \t", i, queue[i]);
            System.out.println();
        }

    }

    /**
     * 展示队列头数据
     */
    public void showHead() {
        isNull();
        System.out.printf("头节点:%d", queue[front + 1]);
        System.out.println();
    }


}
