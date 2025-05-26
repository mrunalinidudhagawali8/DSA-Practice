package com.leetcode;

import java.util.ArrayList;

public class Leetcode659 {
    static int validSubseq = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,5};

        isPossible(nums);
    }
    public static boolean isPossible(int[] nums) {
        if(nums.length<3)return false;

        checkSubsequence(0, nums, new ArrayList<>());

        return validSubseq>1;
    }

    private static void checkSubsequence(int start, int[] nums, ArrayList<Integer> path) {

        for(int i=start;i<nums.length;i++){

            if(path.isEmpty() || nums[i]-path.get(path.size()-1)==1){
                path.add(nums[i]);

                if(path.size()>=3 && start<nums.length) {
                    validSubseq++;
                    System.out.println(path);
                    checkSubsequence(i+1, nums, path);
                    path.remove(path.size()-1);
                }


                checkSubsequence(i+1, nums, path);

                if(!path.isEmpty()) path.remove(path.size()-1);

            }
        }

    }
}
