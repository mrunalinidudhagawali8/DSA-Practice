package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            used[i]=false;
        }

        permutations(0, nums, new ArrayList<>(), res, used);

        return res;
    }
    public static void permutations(int ind, int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used)
    {
        if(used[ind]) return;

        //include
        used[ind] = true;
        path.add(nums[ind]);
        permutations(ind+1, nums, path, res, used);

        // exclude
        path.remove(nums[ind]);
        used[ind] = false;
    }
}
