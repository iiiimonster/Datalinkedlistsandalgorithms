package cn.zwy.structure.stack.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/backspace-string-compare/"> 比较含退格的字符串</a> <BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年07月19日 17:31<BR/>
 */
public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return stack(s).equals(t);
    }

    private String stack(String s) {
        StringBuilder stb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {



        }

    }
}
