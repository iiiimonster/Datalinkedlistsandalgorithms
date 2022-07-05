package cn.zwy.structure.linkedlist.leetcode;


/**
 * &#064;Description:<a href="https://leetcode.cn/problems/reverse-linked-list/206/">单链表反转 力扣206</a>
 * &#064;author:  zwy
 * &#064;date:  2022年07月01日 17:47
 */
public class ReverseLinkedList {


    /**
     * 思路三：迭代法 出栈
     * 1.结合思路二方便理解
     * 2.栈思想是后进先出
     * 3.1. 第一个出栈的是链表结尾，第二个出栈的是链表倒数第二个，把链表倒数第二个
     *
     * @param head 头节点
     * @return 链表
     */
    public static ListNode reverseListThr(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newListNode = reverseListThr(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;
    }


    /**
     * 思路二：迭代
     * 1.遍历链表，每次遍历都把链表放到头后面
     *
     * @param head 头节点
     * @return 链表
     */
    public static ListNode reverseListTwo(ListNode head) {
        ListNode listNode = null;
        for (; head != null; head = head.next) {
            listNode = new ListNode(head.val, listNode);
        }
        return listNode;
    }

    /**
     * 思路一：头插法 迭代
     * 1.缓存进入下次遍历的 链表节点
     * 2.把其他节点放到当前节点的后面
     *
     * @param head 头节点
     * @return 链表
     */
    public static ListNode reverseListOne(ListNode head) {
        ListNode temp;
        ListNode cur = head;
        ListNode listNode = null;
        while (cur != null) {
            temp = cur.next;
            //把当前节点放到开头
            cur.next = listNode;
            listNode = cur;
            cur = temp;
        }
        return listNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }

    public static void main(String[] args) {
        ListNode hear = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode thr = new ListNode(3);
        ListNode fou = new ListNode(4);
        ListNode fir = new ListNode(5);
        ListNode six = new ListNode(6);

        hear.next = one;
        one.next = two;
        two.next = thr;
        thr.next = fou;
        fou.next = fir;
        fir.next = six;

        show(hear);
        System.out.println();
        show(reverseListThr(hear));
    }

    private static void show(ListNode hear) {
        while (hear != null) {
            System.out.print(hear + "\t");
            hear = hear.next;
        }
    }


}
