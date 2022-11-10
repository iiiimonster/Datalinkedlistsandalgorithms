package cn.zwy.algorithm.everyday.leetcode.simple;

import java.util.HashMap;
import java.util.Map;


/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/two-sum/submissions/">1. 两数之和</a>
 * &#064;author:  zwy
 * &#064;date:  2022年11月01日 18:00
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[j]  ==nums[i] ){
                    return new int[]{j,i};
                }
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
