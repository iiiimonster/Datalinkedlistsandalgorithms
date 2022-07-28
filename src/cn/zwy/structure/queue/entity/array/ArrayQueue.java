package cn.zwy.structure.queue.entity.array;

import java.util.Scanner;

/**
 * &#064;Description:   数组实现队列 一次性<BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年06月28日 11:41<BR/>
 */
public class ArrayQueue implements Queue {
    private int front; //头节点 默认为 -1
    private int rear; // 尾节点 默认为 -1
    private final int arrMaxSize; // 队列长度
    private final int[] queue; // 队列数组

    @Override
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
                    try {
                        showHead();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
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
        rear = -1;
        this.arrMaxSize = arrMaxSize;
        queue = new int[arrMaxSize];
    }

    /**
     * 队列已满
     */
    @Override
    public boolean isFUll() {
        if (rear == arrMaxSize - 1) {
            System.out.println("队列已经满了,无法加入");
            return true;
        }
        return false;
    }

    /**
     * 队列是否为空
     */
    @Override
    public boolean isNull() {
        if (front == rear) {
            System.out.println("队列为空,无法输出");
            return true;
        }
        return false;
    }

    /**
     * 添加队列数据
     *
     * @param val 添加的数据
     */
    @Override
    public void addQueue(int val) {
        if (isFUll()) {
            return;
        }
        queue[++rear] = val;
    }

    /**
     * 出队列
     *
     * @return 队列数据
     */
    @Override
    public int getQueue() throws Exception {
        if (isNull()) {
            throw new Exception("队列为空,无法输出");
        }
        return queue[++front];
    }

    /**
     * 查看队列所有数据
     */
    @Override
    public void show() {
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("arr[%d] = %d \t", i, queue[i]);
            System.out.println();
        }
    }

    /**
     * 展示队列头数据
     */
    @Override
    public void showHead() throws Exception {
        if (isNull()) {
            throw new Exception("队列为空,无法输出");
        }
        System.out.printf("头节点:%d", queue[front + 1]);
        System.out.println();
    }


}
