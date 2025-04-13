package com.array;

public class Leetcode53 {
    public static void main(String[] args) {
        System.out.println( maxSubArray(new int[]{1}));
    }
    public static int maxSubArray(int[] nums) {
        int maxSumHere = nums[0];
        int maxSumSoFar = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            maxSumHere = Math.max(maxSumHere + nums[i], nums[i]);

            maxSumSoFar = Math.max(maxSumHere, maxSumSoFar);
        }

        return maxSumSoFar;
    }
}
