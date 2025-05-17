package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    int preInd = 0;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    TreeNode root;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);

    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right)
            return null;

        int inOrderInd = inOrderMap.get(preorder[preInd]);

        TreeNode root = new TreeNode(preorder[preInd++]);

        root.left = build(preorder, left, inOrderInd - 1);
        root.right = build(preorder, inOrderInd + 1, right);

        return root;

    }
}
