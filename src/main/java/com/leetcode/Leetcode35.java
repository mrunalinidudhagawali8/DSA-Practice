package com.leetcode;

public class Leetcode35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,3,4,6,7,8,9}, 3));
    }

    public static int searchInsert(int[] nums, int target) {



        int len = nums.length;
        int l = 0, r = len-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }

        }


            return l;



    }


}
