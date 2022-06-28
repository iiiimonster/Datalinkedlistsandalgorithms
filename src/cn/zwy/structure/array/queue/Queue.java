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
    public void isFUll();

    /**
     * 队列是否为空
     */
    public void isNull();

    /**
     * 添加队列数据
     *
     * @param var 添加的数据
     */
    public void addQueue(int var);

    /**
     * 出队列
     *
     * @return 队列数据
     */
    public int getQueue();

    /**
     * 查看队列所有数据
     */
    public void show();

    /**
     * 展示队列头数据
     */
    public void showHead();

    /**
     * 查看数据
     */
    public void operate();

}
