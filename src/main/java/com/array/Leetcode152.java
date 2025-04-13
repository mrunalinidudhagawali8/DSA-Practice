package com.array;

public class Leetcode152 {
    public static void main(String[] args) {
        System.out.println( maxProduct(new int[]{2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int maxhere = nums[0];
        int minhere = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp = maxhere;
                maxhere = minhere;
                minhere = temp;
            }


            minhere = Math.min(nums[i], minhere*nums[i]);
            maxhere = Math.max(nums[i], maxhere*nums[i]);

            maxProd = Math.max(maxProd, maxhere);

        }

        return maxProd;
    }
}
