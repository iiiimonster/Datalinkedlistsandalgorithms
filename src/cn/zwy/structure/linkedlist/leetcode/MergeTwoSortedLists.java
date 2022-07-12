package cn.zwy.structure.linkedlist.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">合并两个有序链表</a> <BR/>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 <BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月11日 11:05<BR/>
 */
public class MergeTwoSortedLists {


    /**
     * 思路二： 递归<BR/>
     * 1.每次进来先判断 把较小的链表返回 ，并指针后移<BR/>
     * 2.只要其中一个空了就会返回另一个链表的所有数据<BR/>
     *<BR/>
     * @param list1 第一个 链表 a
     * @param list2 第二个 链表 b<BR/>
     * @return 返回 合并链表<BR/>
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }else {
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
    }


    /**
     * 思路一： 迭代<BR/>
     * 1.两个链表不为空则循环<BR/>
     * 2.判断 a的值 和 b的值，如果 a大于等于b 则 a进入 链表并且往后移 反之b<BR/>
     * 3.遍历到最后的链表后面的值是已经遍历完了的链表<BR/>
     * @param list1 第一个 链表 a
     * @param list2 第二个 链表 b <BR/>
     * @return 返回 合并链表<BR/>
     */
    public static ListNode mergeTwoListsOne(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return head.next;
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
    }

}
