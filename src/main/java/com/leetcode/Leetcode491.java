package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        findSubseq(0, res, new ArrayList<>(), nums);

        return new ArrayList<>(res);
    }

    private void findSubseq(int start, Set<List<Integer>> res, List<Integer> path, int[] nums){

        if(path.size()>=2) res.add(new ArrayList<>(path));

        for(int i = start;i <nums.length; i++)
        {
            //first check if path is empty if yes then add current num
            if(path.isEmpty()){
                path.add(nums[i]);
            }
            //need to check if the current num is greater than last element in path
            else if(nums[i]>=path.get(path.size()-1)){
                path.add(nums[i]);
            }

            findSubseq(i+1, res, path, nums);

            if(!path.isEmpty()) path.remove(path.size()-1);

        }
    }
}
