package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<queries.size();i++){
            List<Integer> lis = new ArrayList<>();

            Integer min = findMin(root, queries.get(i));
            Integer max = findMax(root, queries.get(i));

            lis.add(min);
            lis.add(max);

            res.add(lis);
        }

        return res;


    }

    private Integer findMin(TreeNode root, Integer target) {
        if(root==null) return -1;

        if(root.val>target) return findMin(root.left, target);
        if(root.val<target) return findMin(root.right, target);
        return root.val;

    }

    private Integer findMax(TreeNode root, Integer target) {
        if(root==null) return -1;


        if(root.val>target) return findMin(root.right, target);
        if(root.val<target) return findMin(root.left, target);
        return root.val;
    }
}
