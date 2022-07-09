package cn.zwy.structure.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/linked-list-cycle/">环形链表</a>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * &#064;author:  zwy
 * &#064;date:  2022年07月07日 17:35
 */
public class LinkedListCycle {


    /**
     * 思路二：利用 set唯一性结构来 判断是否有回环
     *
     * @param head
     * @return
     */
    public static boolean hasCycleOne(ListNode head) {
        Set<Integer> ints = new HashSet<>();
        while (head!=null){
            if (!ints.add(head.val)) return true;
            head=head.next;
        }
        return false;
    }    /**
     * 思路一：利用 set唯一性结构来 判断是否有回环
     *
     * @param head
     * @return
     */
    public static boolean hasCycleOne(ListNode head) {
        Set<Integer> ints = new HashSet<>();
        while (head!=null){
            if (!ints.add(head.val)) return true;
            head=head.next;
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
