package cn.zwy.structure.linkedlist.entity;


/**
 * &#064;Description:  泛型带头节点单链表
 * 1.泛型带头节点单链表链表，必须初始化链表传入链表头。
 * 2.带头节点特点是删除和添加操作都是一致的
 * 3.引入“哨兵”的情况
 * “哨兵”节点不存储数据，
 * 无论链表是否为空，
 * head指针都会指向它，
 * 作为链表的头结点始终存在。
 * 这样，插入第一个节点和插入其他节点，
 * 删除最后一个节点和删除其他节点都可以统一为相同的代码实现逻辑了。
 * &#064;author:  zwy
 * &#064;date:  2022年06月24日 9:45
 */
public class SinglyLinkedListOfLeadingNodes<T> {
    //长度
    private int size;
    //虚拟头节点
    private final Node<T> vrHead;

    @Override
    public String toString() {
        //调整结构方便查看数据
        return "带头链表长度为:" + size + ",数据{" + vrHead.next + "}end~~~";
    }

    /**
     * 构造函数传入头节点
     *
     * @param data 头节点数据
     */
    public SinglyLinkedListOfLeadingNodes(T data) {
        this.vrHead = new Node<>(data);
    }


    /**
     * 修改下标数据
     * @param index 下标
     * @param data 数据
     */
    public void updataIndex(int index, T data) {
        if (index >= size || index < 0) {
            throw new RuntimeException("链表修改时 下标越界异常");
        }
        Node<T> temp = vrHead;
        Node<T> node = new Node<>(data);
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        node.next=temp.next.next;
        temp.next=node;
    }

    /**
     * 删除对应下标的数据
     * @param index 下标
     */
    public void rmIndex(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("链表删除时 下标越界异常");
        }
        Node<T> temp = vrHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }


    /**
     * 把数据添加到下标
     * @param index 下标
     * @param data  数据
     */
    public void addIndex(int index, T data) {
        if (index > size || index < 0) {
            throw new RuntimeException("链表添加时 下标越界异常");
        }
        Node<T> node = new Node<>(data);
        Node<T> temp = vrHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }
    /**
     * 添加头节点
     * @param data 添加数据
     */
    public void addFirst(T data) {
        addIndex(0, data);
    }
    /**
     * 添加末尾节点
     * @param data 添加数据
     */
    public void addLast(T data) {
        addIndex(size, data);
    }


    //初始化链表

    public static void main(String[] args) {
        SinglyLinkedListOfLeadingNodes<Integer> linked = new SinglyLinkedListOfLeadingNodes<>(-1);
        linked.addFirst(1);
        linked.addFirst(2);
        linked.addFirst(3);
        linked.addFirst(4);
        linked.addFirst(5);
        linked.addLast(6);
        linked.addIndex(3, 22);
        linked.rmIndex(0);
        linked.rmIndex(linked.size - 1);
        linked.updataIndex(0, 9999);
        linked.updataIndex(linked.size-1, 9999);

        System.out.println(linked);
    }


    //泛型节点
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            //节点放在下个数据下面 方便查看数据
            return "数据=" + data + "，"
                    + next;
        }
    }
}
