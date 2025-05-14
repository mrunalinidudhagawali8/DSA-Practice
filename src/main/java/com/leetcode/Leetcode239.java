package com.leetcode;

import java.util.Arrays;

public class Leetcode239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindowBrute(new int[]{1,-1}, 1)));
    }
    public static int[] maxSlidingWindowBrute(int[] nums, int k) {
        int[] maxWindowArr = new int[nums.length-k+1];


        for(int i=0;i<=nums.length-k;i++)
        {
            for(int j=i;j<(i+k);j++)
            {
                maxWindowArr[i] = Math.max(maxWindowArr[i], nums[j]);
            }
        }

        return maxWindowArr;
    }
}
