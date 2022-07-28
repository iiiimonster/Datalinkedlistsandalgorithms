package cn.zwy.structure.stack.entity;

/**
 * &#064;Description:  数组实现栈 <BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月14日 14:35<BR/>
 */
public class ArrayStack {
    /**
     * 数组 stack
     */
    private String[] stack;
    /**
     * 栈中元素个数
     */
    private int count;
    /**
     * 栈空间
     */
    private int size;

    /**
     * 初始化栈
     *
     * @param size 长度
     */
    private ArrayStack(int size) {
        this.stack = new String[size];
        count = 0;
        this.size = size;

    }

    /**
     * 入栈
     * @param val 入栈参数
     */
    private void push(String val) {
        if (count == size) return;
        stack[count++] = val;
    }

    /**
     * 出栈
     * @return 最后入栈的结果
     */
    private String pop (){
        if (count == 0)return "";
        return stack[--count];
    }

    public static void main(String[] args) {
        String a="a";
        String b="b";
        String c="c";
        String d="d";

        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(a);
        arrayStack.push(b);
        arrayStack.push(c);
        arrayStack.push(d);
        for (int i = 4; i > 0; i--) {
            System.out.println(arrayStack.pop());
        }
    }

}
