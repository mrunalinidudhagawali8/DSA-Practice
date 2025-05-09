package com.array;

public class Leetcode230 {

    int count = 0;
    int res ;

    public int kthSmallest(TreeNode root, int k) {

        findKthSmallest(root, k);
        return res;
    }

    private void findKthSmallest(TreeNode root, int k) {
        if(root==null) return;
        findKthSmallest(root.left, k);
        count++;
        if(count==k){
            res= root.val;
        }
        findKthSmallest(root.right, k);

    }
}
