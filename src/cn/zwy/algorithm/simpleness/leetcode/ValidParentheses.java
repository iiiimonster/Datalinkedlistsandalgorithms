package cn.zwy.algorithm.simpleness.leetcode;

/**
 * &#064;Description:    <a href="https://leetcode.cn/problems/valid-parentheses/">有效的括号</a> </BR>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * &#064;author:  zwy
 * &#064;date:  2022年07月14日 16:42
 */
public class ValidParentheses {


    /**
     * 思路一 ： 栈实现
     * 1.如果 s 的长度为 奇数直接返回false
     * 2.依次把左括号放到栈顶
     * 3.每次遇到右括号就取出栈顶左括号对比
     * 3.匹配则继续取出
     * 4.不匹配则返回false
     *
     * @param s 需要对比字符串
     * @return 返回是否为有效括号
     */
    public boolean isValid(String s) {
        if (s.length()%2 ==1){
            return false;
        }
        byte[] bytes = s.getBytes();

    }
}
