package cn.zwy.structure.queue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * &#064;Description: todo  <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/">队列中可以看到的人数</a>
 * &#064;author:  zwy
 * &#064;date:  2022年08月04日 9:35
 */
public class CanSeePersonsCount {

    /**
     * 思路一： 倒序遍历
     * 1.单调递减栈，保存右边的可能看到的人的下标值
     * 2.倒序遍历 能看到多少只与右边的数值有关系
     * 3.比单调栈中当前值小，证明看不到这个值右边的了，结束比较
     * 4.比单调栈中的当前值大，左边的人肯定都看不到这个值之后的人了 出栈
     * 5.单调栈中放入下标，保证单调递减（栈为空或者h[i]<h[j]）
     *
     * @param heights
     * @return
     */
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        // 单调递减栈，保存右边的可能看到的人的下标值
        Deque<Integer> monotoneStack = new ArrayDeque<>();
        // 倒序遍历 能看到多少只与右边的数值有关系
        for (int i = n - 1; i >= 0; i--) {
            while (!monotoneStack.isEmpty()) {
                ans[i]++;
                // 比单调栈中当前值小，证明看不到这个值右边的了，结束比较
                if (heights[i] <= heights[monotoneStack.peek()]) {
                    break;
                }
                // 比单调栈中的当前值大，左边的人肯定都看不到这个值之后的人了
                // 出栈，接着循环
                monotoneStack.pop();
            }
            // 单调栈中放入下标，保证单调递减（栈为空或者h[i]<h[j]）
            monotoneStack.push(i);
        }
        return ans;
    }

    public int[] canSeePersonsCountBAR(int[] heights) {
        int length = heights.length;
        int[] ints = new int[length];
        for (int i = 0; i < length - 1; i++) {
            int temp = i;
            int b = 0;
            int a = heights[i + 1];
            a = Math.max(a, heights[temp]);
            while (++temp < length - 1 && heights[temp] < heights[i]) {
                if (a == heights[temp]) {
                    b++;
                }
            }
            ints[i] = b;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {10,6,8,5,11,9};

        CanSeePersonsCount canSeePersonsCount = new CanSeePersonsCount();
        for (int i : canSeePersonsCount.canSeePersonsCount(ints)) {
            System.out.print( i+"\t");
        }

    }

}
