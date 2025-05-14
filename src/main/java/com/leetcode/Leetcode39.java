package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, new ArrayList<>(), candidates, target, res);
        return res;
    }

    private static void backtrack(int ind, ArrayList<Integer> path, int[] candidates, int target, List<List<Integer>> res) {

        if (ind == candidates.length || target < 0) {
//           path.remove(path.size()-1);//let backtrack remove this naturally
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //include
        path.add(candidates[ind]);

//       🚫 Wrong in recursion — because all paths share the same variable.
//
//✅ Fix:
//        Just pass target - candidates[ind] directly in the recursive call.
//       target = target-candidates[ind];

        backtrack(ind, path, candidates, target - candidates[ind], res);

        //Exclude
        path.remove(path.size() - 1);

//then check again, *here we are not reducing target since we didn’t include candidates[ind] in your path.
//So the target remains the same.
        backtrack(ind + 1, path, candidates, target, res);


    }
}
