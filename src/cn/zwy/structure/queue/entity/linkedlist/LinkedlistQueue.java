package cn.zwy.structure.queue.entity.linkedlist;

import cn.zwy.structure.linkedlist.leetcode.LinkedListCycle;

/**
 * &#064;Description:  单链表实现队列
 * &#064;author:  zwy
 * &#064;date:  2022年07月28日 14:27
 */
public class LinkedlistQueue {


    /**
     * 链表队列
     */
    private ListNode head;
    /**
     * 链表尾节点
     */
    private ListNode temp;
    /**
     * 队列剩余个数
     */
    private int sum;
    public LinkedlistQueue(int val){
        enQueue(val);
    }


    public void enQueue(int val) {
        if (sum ==0) {
            ListNode listNode = new ListNode(val);
            head = listNode;
            temp = listNode;
            sum++;
        }else {
            temp.next = new ListNode(val);
            temp = temp.next;
            sum++;
        }
    }

    public int deQueue() {
        if (sum ==0) throw new RuntimeException("队列为空");
        int temp = head.val;
        //链表删除自己
        head = head.next;
        sum--;
        return temp;

    }

    public static void main(String[] args) {
        LinkedlistQueue linkedlistQueue = new LinkedlistQueue(0);

        linkedlistQueue.enQueue(1);
        linkedlistQueue.enQueue(2);
        linkedlistQueue.enQueue(3);
        linkedlistQueue.enQueue(4);

        for (int i = 0; i < 5; i++) {
            System.out.println(linkedlistQueue.deQueue());
        }
        linkedlistQueue.enQueue(5);
        linkedlistQueue.enQueue(6);

        for (int i = 0; i < 3; i++) {
            System.out.println(linkedlistQueue.deQueue());
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
