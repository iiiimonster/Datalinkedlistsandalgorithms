package cn.zwy.structure.queue.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/maximum-subarray/">最大子数组和</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月02日 16:53
 */
public class maxSubArray {


    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

}
