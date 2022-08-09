package cn.zwy.algorithm.recursion.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/power-of-three/">3 的幂</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月06日 17:23
 */
public class IsPowerOfThree {
    public boolean isPowerOfThreeTwo(int n) {
        return n != 0 && n % 3 == 0 ? isPowerOfThree(n / 3) : n == 1;
    }
    Set<Integer> set = new HashSet<Integer>() {
        {
            add(1);
            add(3);
            add(9);
            add(27);
            add(81);
            add(243);
            add(729);
            add(2187);
            add(6561);
            add(19683);
            add(59049);
            add(177147);
            add(531441);
            add(1594323);
            add(4782969);
            add(14348907);
            add(43046721);
            add(129140163);
            add(387420489);
            add(1162261467);
        }
    };
    public boolean isPowerOfThree(int n) {
        return set.contains(n);
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        System.out.println(isPowerOfThree.isPowerOfThree(27));
    }
}
