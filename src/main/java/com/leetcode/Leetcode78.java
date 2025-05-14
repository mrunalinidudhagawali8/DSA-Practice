package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static void findSubsets(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //inlude curr
        path.add(nums[index]);
        findSubsets(index + 1, nums, path, res);

        //exclude curr
        path.remove(path.size() - 1);
        findSubsets(index + 1, nums, path, res);
    }
}
