package com.array;

public class Leetcode713 {
    public static void main(String[] args) {
        System.out.println( numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // /13.12
        // brute force approach
//
//        int count=0;
//        for(int i=0;i<nums.length;i++)
//        {
//           long prod=1;
//            for(int j=i;j<nums.length;j++)
//            {
//
//                prod *= nums[j];
//                if(prod<k)
//                {
//                    count++;
//                }
//            }
//        }

        //O(n) Approach

        int left=0, right = 0;
        int count=0, prod=1;

        for(right=0; right<nums.length;right++)
        {
            prod *= nums[right];

            //shrinking if prod>=k by increasing left pointer and dividing the prod
            while(prod>=k && left<=right)
            {
                prod /= nums[left];
                left++;
            }

            //Count of subarras would be valid arrays from 'left' and *ending* at 'right
            count += right-left+1;
        }

        return count;
    }
}
