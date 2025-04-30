package com.array;

public class Leetcode154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{10,1,10,10,10}));
    }

    /**
     *
     * HINT :
     *
     * Sometimes, you should decrement end blindly to shrink search space when you can't decide.
     *
     */
    public static int findMin(int[] nums) {
        int start=0, end = nums.length-1;

        if(end==0) return nums[start];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                if (nums[mid] == nums[end]) {
                    end--;
                } else {
                    end = mid;
                }
            }
            if (start == end) return nums[start];
        }

        return nums[start];

        /** More cleaner
         *
         *
         * public int findMin(int[] nums) {
         *     int start = 0, end = nums.length - 1;
         *
         *     while (start < end) {
         *         int mid = start + (end - start) / 2;
         *
         *         if (nums[mid] > nums[end]) {
         *             start = mid + 1;
         *         } else if (nums[mid] < nums[end]) {
         *             end = mid;
         *         } else {
         *             // nums[mid] == nums[end] => can't decide, safely reduce search space
         *             end--;
         *         }
         *     }
         *     return nums[start];
         * }
         */
    }
}
