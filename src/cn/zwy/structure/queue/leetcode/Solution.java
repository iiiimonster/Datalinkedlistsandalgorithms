package cn.zwy.structure.queue.leetcode;

import com.sun.xml.internal.ws.api.pipe.Fiber;

import java.util.ArrayList;
import java.util.List;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/">剑指 Offer 10- I. 斐波那契数列</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月02日 11:21
 */
public class Solution {

    /**
     * 滚动数组
     * @param n 第几位
     * @return 返回结果
     */
    public int fib(int n) {
        int moi = 1000000007;
        if (n < 2) {
            return n;
        }
        int[] ints = new int[2];
        ints[1] = 1;
        for (int i = 0; i < n - 2; i++) {
            int temp = (ints[0] + ints[1])% moi;
            ints[i % 2] = temp;
        }
        return (ints[0] + ints[1]) % moi;

    }

    public int fibtwo(int n) {
        int moi = 1000000007;
        if (n < 2) {
            return n;
        }
        int a, b = 0, t = 1;
        for (int i = 0; i <= n - 2; i++) {
            a = b;
            b = t;
            t = (a + b) % moi;
        }
        return t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(47));
    }
}
