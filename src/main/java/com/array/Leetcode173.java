package com.array;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode173 {

    private Stack<TreeNode> stack = new Stack<>();
    public Leetcode173(TreeNode root) {
        fillStack(root);

    }

    private void fillStack(TreeNode node) {
        while(node!=null)
        {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
           TreeNode curr = stack.pop();
           fillStack(curr.right);
           return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
