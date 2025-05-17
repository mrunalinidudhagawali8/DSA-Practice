package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {

    int postInd;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postInd = postorder.length- 1;

        return build(postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        int inordInd = inorderMap.get(postorder[postInd]);

        TreeNode root = new TreeNode(postorder[postInd--]);

        root.right = build(postorder, inordInd + 1, right);
        root.left = build(postorder, left, inordInd - 1);

        return root;
    }
}
