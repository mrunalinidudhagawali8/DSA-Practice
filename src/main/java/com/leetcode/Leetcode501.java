package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode501 {
    List<Integer> modes = new ArrayList<>();
    Integer prev = null;
    Integer maxCount = 0;
    Integer currCount = 0;

    public int[] findMode(TreeNode root) {

        inOrder(root);

        return modes.stream().mapToInt(i -> i).toArray();

    }

    private void inOrder(TreeNode node) {

        if (node == null)
            return;

        inOrder(node.left);
        handleValues(node);
        inOrder(node.right);

    }

    private void handleValues(TreeNode node) {
        if (prev != null && prev == node.val) {
            currCount++;
        } else {
            currCount = 1;
        }

        if (currCount > maxCount) {
            modes.clear();
            modes.add(node.val);
            maxCount = currCount;
        } else if (currCount == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;
    }
}
