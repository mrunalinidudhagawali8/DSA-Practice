package com.array;

public class Leetcode525 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }
    public static int findMaxLength(int[] nums) {
        int left = 0;
        int maxLen = 0;
        int c0 = 0, c1 = 0;

        if (nums.length == 1) return 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                c0++;
            } else {
                c1++;
            }
            while( (c0 == c1) ) {
                maxLen = Math.max(maxLen, right - left + 1);

                if (nums[left] == 0) {
                    c0--;
                } else {
                    c1--;
                }
                left++;

            }

            while  (right== nums.length-1 && left<right)  {

                if (nums[left] == 0) {
                    c0--;
                } else {
                    c1--;
                }
                left++;

                if(c0==c1) maxLen = Math.max(maxLen, right - left + 1);


            }
        }

        return maxLen;
    }
}
