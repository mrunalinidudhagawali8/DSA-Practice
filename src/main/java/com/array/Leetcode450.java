package com.array;

public class Leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null) return null;

        if(root.val<key) {
            root.right=deleteNode(root.right, key);
        }
        else if(root.val>key) {
            root.left=deleteNode(root.left, key);
        }
        else{
            //have 1 or 2 childs
            if(root.right==null) return root.left;
            if(root.left==null) return root.right;

            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }

        return root;

    }

    private TreeNode getMin(TreeNode node) {

        while(node.left!=null) node= node.left;

        return node;

    }
}
