package cn.zwy.structure.array.sentry;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * @Description: 哨兵模式 简单解决边界模式
 * 场景 给定长度charsSize数组chars中，查找key，返回key所在的位置,
 * @author: zwy
 * @date: 2022年06月15日 11:43
 */
public class BoundaryTreatment {


    public static void main(String[] args) {
        char[] chars = {'1', '2', 'a', 'b', 'c', 'e'};
        int i = notSentry(chars, chars.length, 'e');
        System.out.println(i);


        int e = sentry(chars, chars.length, 'e');
        System.out.println(e);

    }


    /**
     * 无哨兵模式
     *
     * @param chars 字符数组
     * @param key   需要查找的key
     */
    public static int notSentry(char[] chars, int charsSize, char key) {
        if (chars == null || charsSize <= 0) {
            return -1;
        }
        int a = 0;
        // 时间复杂度 O(n) 实际上O(2n)
        while (a < charsSize) {
            System.out.println("非哨兵判断");

            if (chars[a] == key) {
                return a;
            }
            a++;
        }
        return -1;
    }


    /**
     * 哨兵模式
     *
     * @param chars 字符数组
     * @param key   需要查找的key
     */
    public static int sentry(char[] chars, int charsSize, char key) {
        if (chars == null || charsSize <= 0) {
            return -1;
        }
        int c = charsSize - 1;
        //判断最后一位是否是寻找的key
        if (chars[c] == key) {
            return c;
        }
        //设置数组尾部哨兵
        char temp = chars[c];
        chars[c] = key;
        int i = 0;
        //仅需要判断 对应下标的值是否是 key 时间复杂度O(n)
        while (chars[i] != key) {
            System.out.println("哨兵判断");
            i++;
        }
        chars[c] = temp;

        if (i == c) {
            return -1;
        }
        return i;
    }


}
