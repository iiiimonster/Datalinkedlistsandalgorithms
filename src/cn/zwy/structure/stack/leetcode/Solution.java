package cn.zwy.structure.stack.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/backspace-string-compare/"> 比较含退格的字符串</a> <BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月19日 17:31<BR/>
 */
public class Solution {

    public static boolean backspaceCompare(String s, String t) {
        return stack(s).equals(stack(t));
    }

    /**
     * StringBuffer必须toString后才能和string对比
     *
     * @param s 需要处理对象
     * @return string 字符串
     *
     */
    private static String stack(String s) {
        StringBuilder str = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (str.length() > 0) str.deleteCharAt(str.length() - 1);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String a = "abc##a";
        String b = "aa";
        System.out.println(backspaceCompare("abc##a", "abc##a"));
        System.out.println(stack(a).equals(stack(b)));
        System.out.println(stack(a).equals(b));

        System.out.println(stack(a));
        System.out.println(stack(b));

    }
}
