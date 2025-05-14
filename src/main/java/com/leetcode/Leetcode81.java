package com.leetcode;

public class Leetcode81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }
    public static boolean search(int[] nums, int target) {
        int start=0, end=nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target) return true;
            if(nums[mid]<nums[end] && nums[mid]<target && target<=nums[end]){//right part is sorted & target is present in right
                start = mid+1;
            }else
            {
                end=mid;
            }

            if(start==end && nums[end]==target) return true;
        }

        return false;
    }
}
