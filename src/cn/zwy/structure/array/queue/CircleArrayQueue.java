package cn.zwy.structure.array.queue;

import java.util.Scanner;

/**
 * &#064;Description:   环形队列
 * &#064;author:  zwy
 * &#064;date:  2022年06月28日 11:41
 */
public class CircleArrayQueue implements Queue {
    private int front; //头节点 默认为 -1
    private int rear; // 尾节点 默认为 -1
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
    public CircleArrayQueue(int arrMaxSize) {
        this.arrMaxSize = arrMaxSize;
        queue = new int[arrMaxSize];
    }

    /**
     * 队列已满
     */
    public boolean isFUll() {
        if ((rear + 1) % arrMaxSize == front) {
            System.out.println("队列已经满了,无法加入");
            return true;
        }
        return false;
    }

    /**
     * 队列是否为空
     */
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
     * @param var 添加的数据
     */
    public void addQueue(int var) {
        isFUll();
        queue[rear] = var;
        rear = (rear + 1) % arrMaxSize;
    }

    /**
     * 出队列
     *
     * @return 队列数据
     */
    public int getQueue() throws Exception {
        if (isNull()) {
            throw new Exception("队列为空,无法输出");
        }
        int temp = queue[front];

        front = (front + 1) % arrMaxSize;

        return temp;
    }

    /**
     * 查看队列所有数据
     */
    public void show() {
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d] = %d \t", i % arrMaxSize, queue[i % arrMaxSize]);
            System.out.println();
        }
    }

    private int getSize() {
        return (rear + arrMaxSize - front) % arrMaxSize;
    }

    /**
     * 展示队列头数据
     */
    public void showHead() throws Exception {
        if (isNull()) {
            throw new Exception("队列为空,无法输出");
        }
        System.out.printf("头节点:%d", queue[front]);
        System.out.println();
    }

}
