package cn.zwy.structure.linkedlist.leetcode;


/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/design-linked-list/">707. 设计链表</a> <BR/>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。<BR/>
 * 来源：力扣（LeetCode）<BR/>
 * 链接：https://leetcode.cn/problems/design-linked-list<BR/>
 * <BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年09月23日 14:47<BR/>
 */
class MyLinkedList {
    int sum;
    Node hear;

    public MyLinkedList() {
        this.hear = new Node(-1);
    }

    public int get(int index) {
        if (sum < index) {
            return -1;
        }
        Node temp = hear;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        sum++;
        Node node = new Node(val);
        node.next = hear;
        hear = node;
    }

    public void addAtTail(int val) {
        sum++;
        Node temp = hear;
        for (int i = 0; i < sum; i++) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        }
        if (index == sum) {
            addAtTail(val);
        }
        sum++;
        Node temp = hear;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next.next;
        temp.next = node;

    }

    public void deleteAtIndex(int index) {
        if (index> sum){
            return;
        }
        Node temp = hear;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        sum--;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


}
