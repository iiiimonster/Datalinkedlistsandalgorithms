package cn.zwy.structure.linkedlist.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">链表的中间结点</a><BR/>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。<BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月12日 15:49<BR/>
 */
public class MiddleOfTheLinkedList {

    /**
     * 思路二：单指针计算<BR/>
     * 1.遍历链表获取长度 size
     * 2.size%2 == 0 ?  偶数 : 奇数
     * 3.遍历size 偶数 返回 temp.next
     * 3.遍历size 奇数 返回 temp
     *
     * @param head 头链表
     * @return 返回中间节点
     */
    public ListNode middleNodeTwo(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        size = (size / 2) + 1;
        for (int i = 0; i < size; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 思路一：快慢指针<BR/>
     * 1.fast指针每走两步，slow指针就走一步<BR/>
     * 2.链表长度为奇数时 fast快指针在最后的next -> null<BR/>
     * 【1，2，3，4，5】；【3，4，5】；【5】 ,【5】.next==null 跳出循环<BR/>
     * 【1，2，3，4，5】；【2，3，4，5】；【3，4，5】 直接返回 【3，4，5】<BR/>
     * 3.链表长度为偶数时 fast快指针最后会指向 null<BR/>
     * 【1，2，3，4】；【3，4】；【】== null 跳出循环<BR/>
     * 【1，2，3，4】；【2，3，4】；【3，4】 直接返回 【3，4】<BR/>
     *
     * @param head 头链表
     * @return 返回中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
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
