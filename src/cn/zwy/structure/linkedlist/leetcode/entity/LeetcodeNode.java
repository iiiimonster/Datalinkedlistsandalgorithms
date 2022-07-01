package cn.zwy.structure.linkedlist.leetcode.entity;

/**
 * @Description: TODO
 * @author: zwy
 * @date: 2022年07月01日 17:49
 */
public class LeetcodeNode {

    private final int data;
    private LeetcodeNode next;

    public LeetcodeNode(int data) {
        this.data = data;
    }

    public LeetcodeNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        //节点放在下个数据下面 方便查看数据
        return "数据=" + data ;
    }


}
