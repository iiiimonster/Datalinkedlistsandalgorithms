package cn.zwy.structure.linkedlist.leetcode.sword;


import cn.zwy.structure.linkedlist.leetcode.ReverseLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">从尾到头打印链表</a> <BR/>
 * &#064;author:  zwy <BR/>
 * &#064;date:  2022年07月05日 17:39 <BR/>
 */
public class Offer06 {

    static List<Integer> list = new ArrayList<>();
    public static  void recursion(ListNode head){
        if (head== null) return ;
        //先进来的是链表的头
        recursion(head.next);
        //根据栈结构，先出来添加的是最后添加进去的链表末尾
        list.add(head.val);
    }

    /**
     * 思路二： 递归法 recursion <BR/>
     * 1.利用栈先进后出原则
     *
     * @param head 需遍历链表
     * @return 返回倒序数组
     */
    public static int[] reversePrint(ListNode head) {
        list = new ArrayList<>();
        recursion(head);
        int[] ints = new  int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i]=list.get(i);
        }
        return ints;
    }


    /**
     * 思路一： 暴力破解 <BR/>
     * 1. 遍历 head 获取 head 长度 size<BR/>
     * 2. 定义数组 长度为 size<BR/>
     * 3. 遍历链表，每次遍历长度 把数据放到 int [size --]<BR/>
     *
     * @param head 需遍历链表
     * @return 返回倒序数组
     */
    public static int[] reversePrintOne(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode listNode = head;
        int[] ints = new int[size];
        while ((size--) > 0) {
            ints[size] = listNode.val;
            listNode = listNode.next;

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
