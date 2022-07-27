package cn.zwy.structure.stack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/next-greater-element-i/">下一个更大元素 I</a>
 * &#064;author:  zwy
 * &#064;date:  2022年07月26日 9:49
 */
public class NextGreaterElementI {


    /**
     * 思路二：while循环实现
     * 1. 先找到 nums1 i 在 nums2 对应的位置 nums2 j
     * 2. 再判断比 nums2 j 小的数  的位置 nums2 k
     * 3. 如果 k等于 nums2 的长度 m 就代表 没有数比 nums2 j大
     *
     * @param nums1 nums2的子集数组
     * @param nums2 数组
     * @return 返回结果集
     */
    public static int[] nextGreaterElementTwo(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            //先找到 nums2的对应位置
            while (j < m && nums1[i] != nums2[j]) {
                j++;
            }
            int k = j + 1;
            while (k < m && nums2[j] > nums2[k]) {
                k++;
            }
            ints[i] = k < m ? nums2[k] : -1;
        }
        return ints;
    }

    /**
     * 思路一：for循环实现
     *
     * @param nums1 nums2的子集数组
     * @param nums2 数组
     * @return 返回结果集
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length];

        int one = nums1.length;
        int two = nums2.length;

        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two; j++) {
                if (nums1[i] == nums2[j]) {
                    for (; j < two; j++) {
                        if (nums1[i] < nums2[j]) {
                            ints[i] = nums2[j];
                            break;
                        }
                    }
                    if (j == two || ints[i] != nums2[j]) {
                        ints[i] = -1;
                    }
                    break;
                }
            }

        }
        return ints;
    }


    public static void main(String[] args) {
        int[] one = new int[]{1, 3, 5, 2, 4};
        int[] two = new int[]{5, 4, 3, 2, 1};
        for (int i : nextGreaterElement(one, two)) {
            System.out.println(i);
        }


    }
}
