package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode543 {
    static int max=0;
    static TreeNode maxNode = null;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        diameterOfBinaryTree(root);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        TreeNode maxNode = null;
        checkDiameter(root );

        List<Integer> leftPath = new ArrayList<>();
        List<Integer> rightPath = new ArrayList<>();

        getLongestPath(maxNode.left, leftPath);
        getLongestPath(maxNode.right, rightPath);
//        reverse(left)
        return max;
    }

    private static void getLongestPath(TreeNode node, List<Integer> path) {

    }

    private static int checkDiameter(TreeNode node){
        if(node==null) return 0;

        int leftLength = checkDiameter(node.left);
        int rightLength = checkDiameter(node.right);

        if(max<( leftLength+rightLength)){
            max =  leftLength+rightLength;
            maxNode = node;
        }

        return 1+Math.max(leftLength, rightLength);
    }
}
