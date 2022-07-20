package cn.zwy.structure.stack.leetcode;

import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/basic-calculator/">基本计算器</a> <BR/>
 * *在 ASICC码中 0 的编码为 48 所以数字字符 减去 48 得到本身的ASICC编码
 * &#064;author:  zwy <BR/>
 * &#064;date:  2022年07月20日 10:53 <BR/>
 */
public class BasicCalculator {


    /**
     * 思路一 ： 栈结构
     * 1.对于数字处理 用
     * 2.由于只有加号和减号两种运算符，所以括号运算得出的结果 会根据（）前的运算符来反转,然后出栈
     * 2.
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int length = s.length();
        int req = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '+') {
                sign = ops.peek();
            } else if (s.charAt(i) == '-') {
                sign = - ops.peek();
            } else if (s.charAt(i) == ' ') {
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
            } else if (s.charAt(i) == ')') {
                ops.pop();
            } else {
                int a = 0;
                int j = i;
                while (j < length && Character.isDigit(s.charAt(j))) {
                    a = a * 10 + s.charAt(j) - '0';
                    j++;
                }
                req += sign * a;
                if (i != (j-1)){
                    i=j;
                }
            }
        }
        return req;
    }

    public static void main(String[] args) {
        String s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10";
        System.out.println(calculate(s));
        Deque<Integer> ops = new LinkedList<>();
        ops.push(-1);
        ops.push(1);
        System.out.println(-ops.peek());
    }
}
