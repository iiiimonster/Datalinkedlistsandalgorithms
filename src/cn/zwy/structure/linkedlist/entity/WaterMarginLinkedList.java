package cn.zwy.structure.linkedlist.entity;

/**
 * &#064;Description: 水浒传链表练习 带头链表
 * &#064;author:  zwy
 * &#064;date:  2022年07月01日 10:39
 */
public class WaterMarginLinkedList {


    HeroNode head = new HeroNode(0, "");

    public void show() {
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 带头链表添加
     * 添加到节点末尾
     */
    public void add(HeroNode val) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = val;
    }

    static class HeroNode {
        int no;
        String name;
        HeroNode next;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode: " +
                    "[" +
                    "no:" + no
                    +
                    "name:" + name
                    + "]";
        }
    }

    public static void main(String[] args) {
        WaterMarginLinkedList waterMarginLinkedList = new WaterMarginLinkedList();
        HeroNode node1 = new HeroNode(1, "一一");
        HeroNode node2 = new HeroNode(2, "二二");
        HeroNode node3 = new HeroNode(3, "三三");
        HeroNode node4 = new HeroNode(4, "四四");
        HeroNode node5 = new HeroNode(5, "五五");

        waterMarginLinkedList.add(node1);
        waterMarginLinkedList.add(node2);
        waterMarginLinkedList.add(node3);
        waterMarginLinkedList.add(node4);
        waterMarginLinkedList.add(node5);

        waterMarginLinkedList.show();
    }

}

