package com.leetcode;

public class Leetcode209 {
    public static void main(String[] args) {
        System.out.println(bruteforce(4, new int[]{2,3,4}));
    }
    public static int bruteforce(int target, int[] nums)
    {
        int minLen = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                if(sum>=target)
                {
                    minLen = Math.min(minLen, (j-i+1));
                }
            }
        }

        return minLen;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right=0;
        int sum=0;
        int minLen =Integer.MAX_VALUE;

        for(right=0;right<nums.length;right++)
        {

            sum += nums[right];
            while(sum>=target)
            {
                minLen = Math.min(minLen, right-left+1);
                sum-=nums[left];
                left++;
            }


        }

        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }
}
