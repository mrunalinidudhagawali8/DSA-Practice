package com.leetcode;

public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        Long minVal = Long.MIN_VALUE;
        Long maxVal = Long.MAX_VALUE;

        return isValid(root, minVal, maxVal);
    }

    private boolean isValid(TreeNode root, Long minVal, Long maxVal) {

        if(root==null) return true;

        if(root.val>minVal && root.val<maxVal){
            return isValid(root.left, minVal, (long) root.val) && isValid(root.right, (long) root.val, maxVal);
        }
        else{
            return false;
        }
    }
}
