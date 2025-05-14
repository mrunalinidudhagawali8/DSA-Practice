package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,4,1,4};
        Arrays.sort(arr);
        System.out.println(subsetsWithDup(arr));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        powerSet(0, nums,  new ArrayList<>(), res);

        return res;
    }

    private static void powerSet(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for(int i = start; i<nums.length;i++)
        {
            if(i>start && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            powerSet(i+1, nums, path, res);
            path.remove(path.size()-1);
        }
    }
}
