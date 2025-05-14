package com.leetcode;

public class Leetcode918 {
    public static void main(String[] args) {
        System.out.println( maxSubarraySumCircular(new int[]{1}));
    }
    public static int maxSubarraySumCircular(int[] nums) {

        int currMax = nums[0];
        int maxSoFar = nums[0];
        int currMin = nums[0];
        int minSoFar = nums[0];

        int totalSum = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            totalSum += nums[i];

            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSoFar = Math.min(currMin, minSoFar);
        }

        //handles if all elements are negative
        if(maxSoFar<0) return maxSoFar;

        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
