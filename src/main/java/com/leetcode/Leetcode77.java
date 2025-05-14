package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            arr.add(i);
            i++;
        }

        List<List<Integer>> lis = new ArrayList<>();

        combinations(1, n, k, lis, new ArrayList<>());

        return lis;
    }

    private static void combinations(int start, int n, int k, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end <= n; end++) {
            path.add(end);
            combinations(end + 1, n, k, res, path);
            path.remove(path.size() - 1);

        }
    }
}
