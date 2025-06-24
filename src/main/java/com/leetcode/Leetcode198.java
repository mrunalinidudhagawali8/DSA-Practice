package com.leetcode;

public class Leetcode198 {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = Math.max(nums[1], nums[0]);


        for(int i=0;i<n;i++)
        {
            dp[i] = Math.max(nums[i] + dp[i-2], nums[i-1]);
        }

        return dp[n-1];

    }
}
