package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode958{

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) return false;
        que.offer(root);
        boolean nullFlag = false;

        while (!que.isEmpty()) {

            TreeNode node = que.poll();

            if (node == null) {
                nullFlag = true;
            } else {
                if (nullFlag) {
                    return false;
                }

                que.offer(node.left);
                que.offer(node.right);
            }


        }

        return true;

    }
}
