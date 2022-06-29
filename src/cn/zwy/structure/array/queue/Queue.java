package cn.zwy.structure.array.queue;

/**
 * &#064;Description:  队列接口
 * &#064;author:  zwy
 * &#064;date:  2022年06月28日 17:28
 */
public interface Queue {

    /**
     * 队列已满
     */
    boolean isFUll();

    /**
     * 队列是否为空
     */
    boolean isNull();

    /**
     * 添加队列数据
     *
     * @param var 添加的数据
     */
    void addQueue(int var);

    /**
     * 出队列
     *
     * @return 队列数据
     */
    int getQueue() throws Exception;

    /**
     * 查看队列所有数据
     */
    void show();

    /**
     * 展示队列头数据
     */
    void showHead() throws Exception;

    /**
     * 查看数据
     */
    void operate();

    static void main(String[] args) {
        System.out.println(4 % 4);

    }

}
