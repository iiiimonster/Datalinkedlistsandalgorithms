package cn.zwy.structure.linkedlist.leetcode.sword;


import cn.zwy.structure.linkedlist.leetcode.ReverseLinkedList;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">从尾到头打印链表</a>
 * &#064;author:  zwy
 * &#064;date:  2022年07月05日 17:39
 */
public class Offer06 {

    /**
     * 思路一： 暴力破解
     * 1. 遍历 head 获取 head 长度 size
     * 2. 定义数组 长度为 size
     * 3. 遍历链表，每次遍历长度 把数据放到 int [size --]
     *
     * @param head 需遍历链表
     * @return 返回倒序数组
     */
    public static int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode  listNode = head;
        int[] ints = new int[size];
        for (; size <= 0; size--) {
            ints[size] =listNode.val;
            listNode =listNode.next;
        }
        return ints;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            return "val=" + val;
        }
    }

    private static void show(ListNode hear) {
        while (hear != null) {
            System.out.print(hear + "\t");
            hear = hear.next;
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
        int[] ints = reversePrint(hear);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }

    }

}
