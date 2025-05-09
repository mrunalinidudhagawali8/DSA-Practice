package com.array;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given the root of a Binary Search Tree (BST) and a node p in it, return its inorder successor, i.e., the node with the smallest key greater than p.val.
 * If no such node exists, return null.
 *
 * In an inorder traversal (Left → Node → Right), the successor of node p is the next node in that traversal.
 *
 * Constraints:
 * All nodes have unique values
 *
 * You’re guaranteed that p is a valid node in the BST
 *
 * You must not modify the BST
 *
 * Example1 :
 * Tree:        5
 *             / \
 *            3   6
 *           / \
 *          2   4
 *
 *     p = 3
 * Output : Output: Node with value 4
 *
 * Example2 :
 * Tree:        5
 *             / \
 *            3   6
 *           / \
 *          2   4
 *
 * p = 6
 * Output: null
 */
public class Leetcode285_Premium {
    public TreeNode inorderSuccessor_Iterative(TreeNode root, TreeNode p) {
        if(root==null) return null;
        boolean isPFound = false;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null)
            {
                stack.add(curr);
                curr= curr.left;
            }

            TreeNode temp = stack.pop();
            if(temp.val==p.val) isPFound= true;
            else{
                if(isPFound) return temp;
            }
            curr = curr.right;
        }

        return null;

    }
    public TreeNode inorderSuccessor_Recursive(TreeNode root, TreeNode p) {
        if(root==null) return null;

        if(root.val<=p.val) return inorderSuccessor_Recursive(root.right, p);
        else{
            TreeNode left = inorderSuccessor_Recursive(root.left, p);
            if(left!=null){
                return left;
            }else{
                return root;
            }
        }

    }

}
