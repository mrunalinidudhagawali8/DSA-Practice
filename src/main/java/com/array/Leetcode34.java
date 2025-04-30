package com.array;

public class Leetcode34 {
    public int[] searchRange(int[] arr, int target) {

        int l=0, r = arr.length-1;
        int leftend=-1, rightend=-1;

        //find left end
        while(l<=r){
            int mid = l+(r-l)/2;

            if(arr[mid]>=target){
                r = mid-1;
            }else if(arr[mid]<target) l = mid+1;
        }
        //when l==r, it means we found an end
        if (l >= 0 && arr[l] == target) {
            leftend = l;
        }
        l=0; r = arr.length-1;
        //find left end
        while(l<=r){
            int mid = l+(r-l)/2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //when l==r, it means we found an end
        if (r >= 0 && arr[r] == target) {
            rightend = r;
        }
        return new int[]{leftend, rightend};
    }
}
