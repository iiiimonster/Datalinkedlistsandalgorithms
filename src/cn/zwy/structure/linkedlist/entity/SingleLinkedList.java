package cn.zwy.structure.linkedlist.entity;

import java.util.Objects;

/**
 * &#064;Description:  简易链表
 * <p>
 * <a href="https://blog.csdn.net/weixin_49329785/article/details/121699280?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%8D%95%E9%93%BE%E8%A1%A8&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-2-121699280.142">...</a>
 * &#064;author:  zwy
 * &#064;date:  2022年06月17日 15:16
 */
public class SingleLinkedList<T> {
    private int size;
    private Node<T> head;

    @Override
    public String toString() {
        //调整结构方便查看数据
        return "长度为:" + size
                + "\n" + "数据{"
                + "\n" + head + "}end~~~";
    }


    /**
     * 删除指定下标数据
     *
     * @param index 下标
     */
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("删除链表时 下标越界");
        }
        if (index == 0) {
            //删除头节点
            removeHead();
            return;
        }
        Node<T> temp = head;
        //通过 index 定位到辅助节点 temp
        for (int i = 1; i < index; i++) {

            temp = temp.next;
        }
        //temp为待删除节点 ，把temp的下一个节点绑定下下个节点即可完成删除
        temp.next=temp.next.next;
        size--;
    }


    /**
     * 删除头节点 从左边删除
     */
    public void removeHead() {
        if (Objects.nonNull(head)) {
            head = head.next;
            size--;
        } else {
            throw new RuntimeException("链表为空，无法删除头数据");
        }
    }

    /**
     * 替换特定索引的值，并返回旧值
     *
     * @param index  下标
     * @param newVal 新值
     * @return
     */
    public T updata(int index, T newVal) {
        if (size <= index || size < 0) {
            throw new RuntimeException("更改链表时 下标越界");
        }
        //遍历到需要的值
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //获取旧值
        T oldVal = temp.data;
        temp.data = newVal;
        return oldVal;

    }

    public boolean contain(T val) {
        Node<T> temp = head;
        while (temp != null) {
            //使用泛型 需要使用工具类判断
            if (Objects.equals(val, temp.data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    /**
     * 根据下标返回对应数据
     *
     * @param index 下标
     * @return 泛型数据
     */
    public T get(int index) {
        if (size <= index || size < 0) {
            throw new RuntimeException("获取特定数据时 下标越界");
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    public void addTail(T val) {
        addIndex(size, val);
    }

    /**
     * 添加数据到指定位置
     * if 在index=0 则添加头节点
     * if index在长度内，则 foreach 下标找到相对应的数据添加进去
     *
     * @param index 下标
     * @param val   数据
     */
    public void addIndex(int index, T val) {
        //1.判断合法性
        if (size < index || size < 0) {
            throw new RuntimeException("添加链表时 下标越界");
        }
        //2.判断是否头插
        if (index == 0) {
            addHead(val);
        }
        //3.插入元素
        Node<T> node = new Node<T>(val);
        //3.1找到插入前驱，从头节点往后查找
        Node<T> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }


    /**
     * 添加头节点
     * 从左边添加链表
     *
     * @param val 添加数据
     */
    public void addHead(T val) {
        Node<T> node = new Node<>(val);
        if (head != null) {
            //头节点有数据，把头节点数据向后移，并把头节点插入
            node.next = head;
        }
        //直接添加到头节点
        head = node;
        size++;
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }


        @Override
        public String toString() {
            //节点放在下个数据下面 方便查看数据
            return "数据=" + data + "，\n"
                    + next;
        }

    }

    public static void main(String[] args) {
        SingleLinkedList<Double> singleLinkedList = new SingleLinkedList<>();
        //从头插入5条数据(从最左边插入数据  4，3，2，1，0)
        singleLinkedList.addHead(0d);
        singleLinkedList.addHead(1d);
        singleLinkedList.addHead(2d);
        singleLinkedList.addHead(3d);
        singleLinkedList.addHead(4d);
        //在下标为1  数据插入一个 3.1
        singleLinkedList.addIndex(1, 3.1);
        //在尾部  后面插入 11 （4，3.1，3，2，1，0，-0.1）
        singleLinkedList.addTail(-0.1);
        //根据下标 6 获取某个数据
        System.out.println(singleLinkedList.get(6));
        //判断链表是否存在 数据
        System.out.println(singleLinkedList.contain(3.1));
        //替换链表 索引为1的数据 为 999 ,并获取旧值 3.1 （4，999，3，2，1，0，-0.1）
        System.out.println(singleLinkedList.updata(1, 999d));
        //删除头节点（999，3，2，1，0，-0.1）
        singleLinkedList.removeHead();
        //删除下标为1的数据
        singleLinkedList.remove(1);


        //查看链表数据
        System.out.println(singleLinkedList);
    }

}
