package cn.zwy.structure.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/">83. 删除排序链表中的重复元素</a>
 * &#064;author:  zwy
 * &#064;date:  2022年07月13日 11:14
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * 思路二：一次遍历（链表为升序链表）
     *
     * @param head 处理链表
     * @return 返回链表结果
     */
    public ListNode deleteDuplicatesTwo(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 思路一： 利用set的唯一特性 迭代版本 (链表无需排序)
     *
     * @param head 处理链表
     * @return 返回链表结果
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode tempt = head;
        Set<Integer> integers = new HashSet<>();
        integers.add(head.val);
        while (temp != null) {
            boolean add = integers.add(temp.val);
            if (add) {
                tempt = tempt.next;
            } else {
                tempt.next = tempt.next.next;
            }
            temp = temp.next;
        }
        return head;
    }


    public class ListNode {
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
    }
}
