package com.leetcode;

public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(p.val<root.val && q.val<root.val){
            //LCA is in left half
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val>root.val && q.val>root.val)
        {
            //LCA is in right half
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
