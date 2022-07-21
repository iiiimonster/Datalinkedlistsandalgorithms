package cn.zwy.structure.stack.leetcode;

import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

/**
 * &#064;Description:   <a href="https://leetcode.cn/problems/basic-calculator/">基本计算器</a> <BR/>
 * 在 ASICC码中 0 的编码为 48 所以数字字符 减去 48 得到本身的ASICC编码<BR/>
 * &#064;author:  zwy <BR/>
 * &#064;date:  2022年07月20日 10:53 <BR/>
 */
public class BasicCalculator {
    /**
     * 思路一 ： 栈结构 for循环<BR/>
     * 1.ops 用于 储存运算符，括号内的运算符<BR/>
     * 2.由于字符串只有 +-() 和空格 所以根据条件遍历即可<BR/>
     * 3.遇到 空格 跳过<BR/>
     * 4.遇到 + 时 由于 有理数乘法法则  ops栈的栈顶符号不变<BR/>
     * 5.遇到 - 时 由于 有理数乘法法则  ops栈的栈顶符号取反 <BR/>
     * 6.遇到 ( 时 把当前符号 sign 压栈<BR/>
     * 7.遇到 ) 时 把ops栈的顶部 符号出栈<BR/>
     * 8.遇到数字时，继续循环，只要有相邻的数字就把当前数字 ×10 进一位，然后再加上当前 char类型数字 <BR/>
     * （*注在 ASICC码中 0 的编码为 48 所以数字字符 减去 48 得到本身的ASICC编码）<BR/>
     * 得到的数据 和赋值当前 符号 sign * a 然后在进行运算<BR/>
     *<BR/>
     * @param s 字符串
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
                sign = -ops.peek();
            } else if (s.charAt(i) == ' ') {
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
            } else if (s.charAt(i) == ')') {
                ops.pop();
            } else {
                int a = 0;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    a = a * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                req += sign * a;

            }
        }
        return req;
    }


    /**
     * 官网解法
     * @param s
     * @return
     */
    public int calculateTwo(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int i = 1 - (3 + 5 - 2 + (3 + 19 - (3 - 1 - 4 + (9 - 4 - (4 - (1 + (3) - 2) - 5) + 8 - (3 - 5) - 1) - 4) - 5) - 4 + 3 - 9) - 4 - 10;
        String s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-10";
        String s1 = " 1 - (3 + 5 - 2 + (3 + 19 - (3 - 1 - 4 + (9 - 4 - (4 - (1 + (3) - 2) - 5) + 8 - (3 - 5) - 1) - 4) - 5) - 4 + 3 - 9) - 4 - 10";
        System.out.println(calculate(s));
        Deque<Integer> ops = new LinkedList<>();
        ops.push(-1);
        ops.push(1);
        System.out.println(-ops.peek());
    }
}
