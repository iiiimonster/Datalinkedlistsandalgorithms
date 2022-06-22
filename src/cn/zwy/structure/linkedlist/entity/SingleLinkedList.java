package cn.zwy.structure.linkedlist.entity;

import java.util.Objects;

/**
 * &#064;Description:  简易链表
 * <p>
 * <a href="https://blog.csdn.net/weixin_49329785/article/details/121699280?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%8D%95%E9%93%BE%E8%A1%A8&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-2-121699280.142">...</a>
 * &#064;author:  zwy
 * &#064;date:  2022年06月17日 15:16
 */
public class SingleLinkedList {
    private int size;
    private Node head;

    /**
     * 判断所需要操作的位置节点是否存在
     *
     * @param index 链表长度
     * @throws Exception 抛出异常
     */
    public void outLength(int index) throws Exception {
        if (size < index || size < 0) {
            throw new Exception("链表长度越界");
        }
    }

    /**
     *
     * 添加数据到指定位置
     * if 在index=0 则添加头节点
     * if index在长度内，则 foreach 下标找到相对应的数据添加进去
     *
     * @param index 下标
     * @param val 数据
     */
    public void addIndex(int index, int val) throws Exception {
        outLength(index);
        Node node = new Node(val);



    }

    /**
     * 添加头节点
     * 从左边添加链表
     *
     * @param val 添加数据
     */
    public void addHead(int val) {
        Node node = new Node(val);
        if (Objects.equals(head, node)) {
            //头节点没有数据，直接添加到头节点
            head = node;
        } else {
            //头节点有数据，把头节点数据向后移，并把头节点插入
            head.next = head;
            head = node;
        }
        size++;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "节点{" +
                    "数据=" + data + '}';
        }

    }


}
