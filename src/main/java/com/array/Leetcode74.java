package com.array;

public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len  = matrix[0].length;
        int brd =  matrix.length;
        int start = 0, end = (len*brd)-1;



        while(start<=end){
            int mid = start + (end-start)/2;
            int ele = matrix[mid/len][mid%len];
            if(ele==target) return true;
            if(ele<target){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }

        return false;
    }
}
