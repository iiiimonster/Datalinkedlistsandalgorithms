package cn.zwy.structure.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/linked-list-cycle/">环形链表</a><BR/>
 * 给你一个链表的头节点 head ，判断链表中是否有环。<BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月07日 17:35<BR/>
 */
public class LinkedListCycle {


    /**
     * 思路三(内存O(1))：Floyd 判圈算法（快慢指针）标记head
     * 1. 慢指针走一步，快指针走两步
     * 2. 只要有回环快指针总会和慢指针相遇
     * 3. 没有回环 快指针会指向空
     *
     * @param head 判断入参
     * @return 返回结果
     */
    public static boolean hasCyclethr(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        while (head != head.next) {
            if (head.next == null || head.next.next == null) {
                return false;
            }
            head = head.next;

        }
        return true;
    }
    /**
     * 思路二(官方写法)：Floyd 判圈算法（快慢指针）
     * 1. 慢指针走一步，快指针走两步
     * 2. 只要有回环快指针总会和慢指针相遇
     * 3. 没有回环 快指针会指向空
     *
     * @param head 判断入参
     * @return 返回结果
     */
    public static boolean hasCycleTwoOffcial(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quick = head.next;
        while (head != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            head = head.next;
            quick = quick.next.next;
        }
        return true;
    }

    /**
     * 思路二：Floyd 判圈算法（快慢指针）
     * 1. 慢指针走一步，快指针走两步
     * 2. 只要有回环快指针总会和慢指针相遇
     * 3. 没有回环 快指针会指向空
     *
     * @param head 判断入参
     * @return 返回结果
     */
    public static boolean hasCycleTwo(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode quick = head;
        while (true) {
            if (quick == null || quick.next == null) {
                return false;
            }
            head = head.next;
            quick = quick.next.next;
            if (head == quick) {
                return true;
            }
        }
    }

    /**
     * 思路一：利用 set唯一性结构来 判断是否有回环
     *
     * @param head 判断入参
     * @return 返回结果
     */
    public static boolean hasCycleOne(ListNode head) {
        Set<ListNode> ints = new HashSet<>();
        while (head != null) {
            if (!ints.add(head)) return true;
            head = head.next;
        }
        return false;
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

        System.out.println(hasCycleOne(hear));
    }

    private static void show(ListNode hear) {
        while (hear != null) {
            System.out.print(hear + "\t");
            hear = hear.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
