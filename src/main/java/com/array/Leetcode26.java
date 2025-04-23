package com.array;

import org.springframework.boot.security.reactive.ApplicationContextServerWebExchangeMatcher;

public class Leetcode26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int  write=0, read;

        //if len==1 return 1
        if(nums.length==1) return 1;

        for(read=1;read<nums.length;read++)
        {
            if(nums[read-1]!=nums[read])
            {
                write++;
                nums[write] = nums[read];
            }
        }

        return (write==0)?1:write+1;
    }

    //Also TC(O(n))
    public static int removeDuplicatesBrute(int[] nums) {
        int uniqueCount = 0, ind = 0;

        for (int i = 0; i < nums.length;) {
            int temp = nums[i];
            uniqueCount++;
            while (i < nums.length && nums[i] == temp) {
                i++;
            }

            if (i == nums.length) {
                break;
            }
            nums[++ind] = nums[i];
        }

        return uniqueCount;
    }
}
