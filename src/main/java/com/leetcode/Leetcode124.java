package com.leetcode;

public class Leetcode124 {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxPathSum = Integer.MIN_VALUE;;

        dfs(root);

        return maxPathSum;
    }

    private int dfs(TreeNode root) {

        if(root==null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.left);

        maxPathSum = Math.max(maxPathSum, left+right+root.val);

        return Math.max(left, right)+root.val;
    }
}
