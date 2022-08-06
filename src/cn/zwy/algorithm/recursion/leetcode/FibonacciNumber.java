package cn.zwy.algorithm.recursion.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/fibonacci-number/">斐波那契数</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月06日 17:17
 */
public class FibonacciNumber {

    /**
     * 思路一: 递归实现
     *
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        System.out.println(fibonacciNumber.fib(4));
    }
}
