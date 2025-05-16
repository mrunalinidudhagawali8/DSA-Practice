package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode653 {
    Set<Integer> hs = new HashSet<>();
    Boolean isFound = false;

    public boolean findTarget(TreeNode root, int k) {
        traverseInOrder(root, k);
        return isFound;
    }

    private void traverseInOrder(TreeNode root, int k) {
        if (root == null)
            return;
        traverseInOrder(root.left, k);
        //check if hm contains other part else add in hm

        if (hs.contains(k - root.val)) {
            isFound = true;
            return;
        }
        hs.add(root.val);
        traverseInOrder(root.right, k);
    }
}
