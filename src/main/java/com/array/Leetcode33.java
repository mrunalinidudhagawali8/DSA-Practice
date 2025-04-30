package com.array;

public class Leetcode33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }
    public static int search(int[] nums, int target) {
        int start=0, end = nums.length-1;

        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(nums[mid]==target) return mid;
            else if(nums[start]<=nums[mid])//left part id sorted
            {
                if(nums[start]<=target && target<nums[mid]){//target is present in left
                    end = mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[end]){//target is present in left
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}
