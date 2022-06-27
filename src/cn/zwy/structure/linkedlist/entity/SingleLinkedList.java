package cn.zwy.structure.linkedlist.entity;

import java.util.Objects;

/**
 * &#064;Description:  简易无头单链表
 * <p>
 * 参考下文
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
        return "长度为:" + size + ",数据{" + head + "}end~~~";
    }

    /**
     * 递归版本删除链表所包含数据
     * leetcode203题：给定一个头节点为head的链表,删除该链表中所有值为val节点并返回删除后的头节点
     *  https://leetcode.cn/problems/remove-linked-list-elements/
     *
     * @param head 递归节点
     * @param val  判断的值
     * @return 返回节点
     */
    public Node<T> removeValueAll(Node<T> head, T val) {
        //头节点为空时 默认到达尾节点
        if (Objects.isNull(head)) {
            return null;
        }
        head.next = removeValueAll(head.next, val);
        // head.data 等于上一个传入的值 head.next 的数据
        if (Objects.equals(head.data, val)) {
            //返回 head.next 相当于 head.next = head.next.next
            // 结合另一个removeValueAll方法 来看方便理解
            size--;
            return head.next;
        }
        //相当于 返回 传进来的数据 链表长度不变
        return head;
    }
//    public SingleLinkedList<T> removeValueAll(SingleLinkedList<T> head,T val){
//    }


    /**
     * 删除链表所有该值 普通实现（方便理解下一个递归版本）
     * 1. 遍历 删除头节点 头节点会重置
     * 2. 判断 中间节点开始判断删除
     *
     * @param val 数据
     */
    public void removeValueAll(T val) {
        // *难点* ： 删除头节点后 头节点会重置 所以要使用while
        while (Objects.nonNull(head) && Objects.equals(head.data, val)) {
            //头节点删除
            head = head.next;
            size--;
        }
        //判断完头节点后对中间节点做处理
        Node<T> temp = head;
        while (Objects.nonNull(temp.next)) {
            if (Objects.equals(temp.next.data, val)) {
                //满足删除条件 进行删除
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * 删除第一个出现 val 的值
     * 1.判断val不是头节点
     * 2.遍历链表并删除特定节点
     *
     * @param val 删除的值
     */
    public void removeValueOnce(T val) {
        if (Objects.nonNull(head) && Objects.equals(val, head.data)) {
            //头节点删除
            head = head.next;
            size--;
        } else {
            Node<T> temp = head;
            while (Objects.nonNull(temp.next)) {
                if (Objects.equals(temp.next.data, val)) {
                    //满足删除条件 进行删除
                    temp.next = temp.next.next;
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }


    /**
     * 删除链表尾部数据
     */
    public void removeLast() {
        remove(size - 1);
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
        temp.next = temp.next.next;
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
     * @return 返回 T
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

    /**
     *
     * 判断链表是否包含数据
     *
     * @param val 所需判断数据
     * @return true：false
     */
    public boolean contain(T val) {
        Node<T> temp = head;
        while (Objects.nonNull(temp)) {
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


    /**
     *
     * 添加数据到末尾
     *
     * @param val 参数
     */
    public void addLast(T val) {
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
        if (Objects.nonNull(head)) {
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
            return "数据=" + data + "，"
                    + next;
        }

    }

    public static void main(String[] args) {
        SingleLinkedList<Double> singleLinkedList = new SingleLinkedList<>();
        //从头插入5条数据(从最左边插入数据)
        singleLinkedList.addHead(0d);
        singleLinkedList.addHead(1d);
        singleLinkedList.addHead(2d);
        singleLinkedList.addHead(3d);
        singleLinkedList.addHead(4d);
        //在下标为1  数据插入一个 3.1
        singleLinkedList.addIndex(1, 3.1);
        //在尾部  后面插入 11 （
        singleLinkedList.addLast(-0.1);
        //根据下标 6 获取某个数据
        System.out.println(singleLinkedList.get(6));
        //判断链表是否存在 数据 true
        System.out.println(singleLinkedList.contain(3.1));
        //替换链表 索引为1的数据 为 999 ,并获取旧值 3.1
        System.out.println(singleLinkedList.updata(1, 999d));
        //删除头节点
        singleLinkedList.removeHead();
        System.out.println(singleLinkedList);
        //删除下标为1的数据
        singleLinkedList.remove(1);
        //删除末尾数据
        singleLinkedList.removeLast();
        //删除 1.0
        singleLinkedList.removeValueOnce(1.0);
        // 通过递归 删除全部  999
        singleLinkedList.addHead(999d);
        singleLinkedList.addHead(999d);
        singleLinkedList.addHead(999d);
        singleLinkedList.addHead(999d);
        singleLinkedList.addHead(999d);
        System.out.println(singleLinkedList);
        singleLinkedList.head = singleLinkedList.removeValueAll(singleLinkedList.head, 999d);

        System.out.println(0==0 && 1==1? true:false);

        //查看链表数据
        System.out.println(singleLinkedList);
    }

}
