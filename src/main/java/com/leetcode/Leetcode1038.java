package com.leetcode;

public class Leetcode1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);

        return root;
    }

    private void reverseInorder(TreeNode root){
        if(root==null) return;

        reverseInorder(root.right);
        root.val += sum;
        sum = root.val;
        reverseInorder(root.left);
    }
}
