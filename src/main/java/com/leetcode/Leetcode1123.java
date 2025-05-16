package com.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        //find deepest nodes : if only 1 then return it and if mutlitple then find the farthest two
        List<TreeNode> deepestNodes = findMostDeepNodes(root);

        if(deepestNodes.size()==1) return deepestNodes.get(0);

        //take LCA of farthest two nodes
        return LCA(root, deepestNodes.get(0), deepestNodes.get(1));
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null) return right;
        return left;
    }

    private List<TreeNode> findMostDeepNodes(TreeNode root) {

        List<TreeNode> leaves = new ArrayList<>();
        if (root == null)
            return leaves;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {

            int size = que.size();
            leaves.clear();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                leaves.add(node);

                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);
            }
        }

        //if leaves size is 1 : return
        if (leaves.size() == 1)
            return leaves;
        else {
            //keep only first and last nodes in leaves lis
            TreeNode first = leaves.get(0);
            TreeNode last = leaves.get(leaves.size() - 1);

            leaves.clear();
            leaves.add(first);
            leaves.add(last);

            return leaves;
        }

    }
}
