package com.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Leetcode270_Premium {

    Double closestDiff = Double.POSITIVE_INFINITY;
    Integer closestNode;

    public int closestValue(TreeNode root, double target) {
        closestNode = root.val;
        bst(root, target);
        return closestNode;
    }

    private void bst(TreeNode root, double target) {
        if (root == null) return;

        if (closestDiff > Math.abs(root.val - target)) {
            closestDiff = Math.abs(root.val - target);
            closestNode = root.val;
        }

        if (root.val < target) {

            bst(root.right, target);
        } else {
            bst(root.left, target);
        }
    }
}
