package cn.zwy.structure.linkedlist.leetcode.sword;

import cn.zwy.structure.linkedlist.entity.SingleLinkedList;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">链表中倒数第k个节点</a>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * &#064;author:  zwy
 * &#064;date:  2022年07月04日 11:38
 */
public class Offer22 {

    /**
     * 思路二：快慢指针（双指针） 时间：O(n)
     * 1.快指针 fast 先走 k 步
     * 2.慢指针 slow 和 快指针 fast 一起走
     * 3.快指针 fast 到最后，慢指针 slow指的就是倒数第k个
     * 4.返回慢指针 slow
     *
     * @param head 链表头节点
     * @param k    倒数第k位
     * @return 链表
     */
    public static ListNode two(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        ListNode slow = head;
        while (fast.next!=null){
            slow=slow.next;
              fast=fast.next;
        }
        return slow;
    }

    /**
     * 思路一：单指针
     * 1.先遍历所有数据获取链表长度 size 时间O(n)
     * 2.size ➖ k 获取遍历次数  时间O(n): 循环 n次
     * 3.for 遍历 返回链表
     *
     * @param head 链表头节点
     * @param k    倒数第k位
     * @return 链表
     */
    public static ListNode one(ListNode head, int k) {
        int size = 0;
        boolean flag = true;
        ListNode temp = head;
        while (flag) {
            size++;
            if (temp.next == null) {
                flag = false;
            }
            temp = temp.next;
            System.out.println(size);
        }

        int t = size - k;

        ListNode listNode = head;
        for (int i = 0; i < t; i++) {
            listNode = listNode.next;
        }

        return listNode;
    }

    /**
     * 思路一：单指针 （单临时变量）
     * 1.先遍历所有数据获取链表长度 size 时间O(n) 空间O(n)： 定义临时变量 temp
     * 2.size ➖ k 获取遍历次数  时间O(n): 循环 n次 ，空间O(n)： 定义临时变量 temp
     * 3.for 遍历 返回链表
     *
     * @param head 链表头节点
     * @param k    倒数第k位
     * @return 链表
     */
    public static ListNode oneVarietas(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp.next!=null){
            temp=temp.next;
            size++;
        }
        size = size - k;
        temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        return temp;
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
        six.next = null;

        System.out.println(one(hear, 3));


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val :" + val;
        }
    }
}
