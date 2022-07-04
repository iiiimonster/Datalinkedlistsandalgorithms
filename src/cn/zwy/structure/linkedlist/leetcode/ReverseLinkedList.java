package cn.zwy.structure.linkedlist.leetcode;

import cn.zwy.structure.linkedlist.leetcode.sword.Offer22;

/**
 * &#064;Description:<a href="https://leetcode.cn/problems/reverse-linked-list/206/">单链表反转 力扣206</a>
 * &#064;author:  zwy
 * &#064;date:  2022年07月01日 17:47
 */
public class ReverseLinkedList {


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
        show(reverseListOne(hear));
    }

    private static void show(ListNode hear) {

        while (hear != null) {
            System.out.print(hear + "\t");
            hear = hear.next;
        }
    }

    /**
     * 思路一：头插法
     * 1.反转链表赋值给 当前链表的 下一个 （当前链表往后移）
     * 2.当前链表 赋值给 反转链表 头赋值给头
     * 3.然后 当前链表往后移 反复
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


}
