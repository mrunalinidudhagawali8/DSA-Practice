package com.array;

public class Leetcode153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
    public static int findMin(int[] arr) {
        int min= Integer.MAX_VALUE;

        int start=0, end=arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //check if both left and right part are sorted-if sorted -
            // then note the min of both ends, which ever is minimum return that
            if (arr[start] <= arr[mid] && arr[mid] <= arr[end]) {
                return Math.min(min, arr[start]);
            } else if (arr[start] <= arr[mid] && arr[mid] > arr[end])//left is sorted but right is not then min is present in right
            {
                start = mid + 1;
            } else if (arr[mid + 1] <= arr[end] && arr[start] > arr[mid])//right is sorted but left is not then min is present in left
            {
                end = mid;
            }

//            more optimal :
//            int start = 0, end = nums.length - 1;
//
//            while (start < end) {
//                int mid = start + (end - start) / 2;
//
//                if (nums[mid] > nums[end]) {
//                    start = mid + 1; // min is in right half
//                } else {
//                    end = mid; // min is at mid or left half
//                }
//            }
//            return nums[start];
        }
        return min;

    }
}
