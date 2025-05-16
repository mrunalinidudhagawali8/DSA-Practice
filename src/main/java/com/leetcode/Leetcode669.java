package com.leetcode;

public class Leetcode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        return pruneBSTInOrder(root, low, high);
    }

    private TreeNode pruneBSTInOrder(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        root.left = pruneBSTInOrder(root.left, low, high);

        root.right = pruneBSTInOrder(root.right, low, high);

        if (root.val < low || root.val > high) {
            return deleteNode(root);
        }

        return root;

    }

    private TreeNode deleteNode(TreeNode root) {
        //if node is leaf
        if (root.left == null && root.right == null) {
            return null;
        }

        //if it had only one child
        if (root.left != null)
            return root.left;
        if (root.right != null)
            return root.right;

        //if it has both kids
        TreeNode newRoot = root.left;
        TreeNode rightmost = newRoot;

        while (root.right != null) {
            rightmost = rightmost.right;
        }

        rightmost.right = root.right;
        return newRoot;

    }
}
