package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int robCheck1 = robCheck(nums, 0, n-2);
        int robCheck2 = robCheck(nums, 1, n-1);

        return Math.max(robCheck1, robCheck2);
    }

    private int robCheck(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for(int i=start;i<=end;i++)
        {
            int temp = Math.max(prev1, nums[i]+prev2);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;

    }
}
