package com.leetcode;

import java.util.*;

public class Leetcode297 {

    int ind = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtility(root, sb);

        return sb.toString();
    }

    private void serializeUtility(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        serializeUtility(root.left, sb);
        serializeUtility(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        ind = 0;

        return deserializeHelpper(nodes);
    }

    private TreeNode deserializeHelpper(String[] nodes) {
        if(nodes[ind].equals("null")){
            ind++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[ind++]));
        node.left = deserializeHelpper(nodes);
        node.right = deserializeHelpper(nodes);

        return node;
    }

}
