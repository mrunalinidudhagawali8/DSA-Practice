package com.array;

import java.util.Stack;

public class Leetcode99 {
    int bad1=Integer.MIN_VALUE, bad2;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode prev = null;
        TreeNode anomaly1 = null, anomaly2 = null;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            if (prev != null && prev.val > temp.val) {
                if (anomaly1 == null) anomaly1 = prev;
                anomaly2 = temp;
            }
            prev = temp;
            curr = temp.right;
        }

        //swap values
        int swapme = anomaly1.val;
        anomaly1.val = anomaly2.val;
        anomaly2.val = swapme;
    }

    public TreeNode recoverTreeRecursive(TreeNode root, TreeNode prev){

        if(root==null)
            return null;

        prev = recoverTreeRecursive(root.left, prev);
        if (prev != null && prev.val > root.val) {
            if (bad1==Integer.MIN_VALUE) bad1 = prev.val;
            bad2 = root.val;

            return root;
        }
        prev = recoverTreeRecursive(root.right, prev);

        return prev;


    }
}
