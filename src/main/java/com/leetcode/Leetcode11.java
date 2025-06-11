package com.leetcode;

public class Leetcode11
{
    public int maxArea(int[] height) {

        int i = 0, j = height.length-1;

        int maxWater = Integer.MIN_VALUE;

        while(i<j)
        {
            int waterTrapped = (j-i)*Math.min(height[i], height[j]);

            maxWater = Math.max(maxWater, waterTrapped);

            if(i<j) i++;
            else j++;
        }

        return maxWater;
    }
}
