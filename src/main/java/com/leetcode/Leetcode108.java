package com.leetcode;

public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root = createBST(nums, 0, nums.length-1, root);
        return root;
    }

    private TreeNode createBST(int[] nums, int start, int end, TreeNode root) {
        if (end < start) return null;

        int mid = start+(end - start) / 2;
        root = new TreeNode(nums[mid]);

        root.left = createBST(nums, start, mid - 1, root);
        root.right = createBST(nums, mid + 1, end, root);

        return root;
    }
}
