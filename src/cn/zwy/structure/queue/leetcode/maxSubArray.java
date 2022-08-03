package cn.zwy.structure.queue.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/maximum-subarray/">最大子数组和</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月02日 16:53
 */
public class maxSubArray {


    /**
     * 动态规划
     * @param nums 处理数组
     * @return 返回最大值
     */
    public int maxSubArrayTwo(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
        }
        int a= nums[0];
        for (int num : nums) {
            if (num>a){
                a = num;
            }
        }

        return a;
    }

    /**
     * 贪心算法
     * @param nums 处理数组
     * @return 返回最大值
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

}
