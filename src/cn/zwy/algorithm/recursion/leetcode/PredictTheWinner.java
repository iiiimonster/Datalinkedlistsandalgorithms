package cn.zwy.algorithm.recursion.leetcode;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/predict-the-winner/">预测赢家</a> <BR/>
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。<BR/>
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。<BR/>
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。<BR/>
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。<BR/>
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。<BR/>
 * 来源：力扣（LeetCode）<BR/>
 * 链接：<a href="https://leetcode.cn/problems/predict-the-winner">预测赢家</a><BR/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年08月09日 15:50<BR/>
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1) >= 0;
    }

    /**
     * 思路一：递归
     * 
     *
     * @param nums  数组
     * @param start 数组起始位置
     * @param end   数组结束位置
     * @return 返回最终结果
     */
    public int total(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int scoreStart = nums[start] - total(nums, start + 1, end);
        int scoreEnd = nums[end] - total(nums, start, end - 1);
        return Math.max(scoreStart, scoreEnd);
    }

}

