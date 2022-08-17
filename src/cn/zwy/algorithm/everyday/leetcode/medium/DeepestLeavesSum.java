package cn.zwy.algorithm.everyday.leetcode.medium;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/deepest-leaves-sum/">1302. 层数最深叶子节点的和</a><BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年08月17日 11:53<BR/>
 */
public class DeepestLeavesSum {


    int maxLevel = -1;
    int sum = 0;


    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    /**
     * 深度优先搜索 DFS （递归处理）
     * 1.先判断当前深度是否满足最深深度 maxLevel
     * 1.1 当前深度比最大深度大 覆盖最大深度，重置总数
     * 1.2 当前深度等于最大深度，累计添加
     *
     * @param root 需要计算的树
     * @param i 当前深度
     */
    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (i > maxLevel) {
            maxLevel = i;
            sum = root.val;
        } else if (i == maxLevel) {
            sum += root.val;
        }

        dfs(root.left, i + 1);
        dfs(root.right, i + 1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
