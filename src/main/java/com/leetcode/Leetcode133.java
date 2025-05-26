package com.leetcode;

import java.util.*;

public class Leetcode133 {


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Map<Node, Node> cloneMap = new HashMap<>();
        return dfs(node, cloneMap);

    }

    Node dfs(Node node, Map<Node, Node> cloneMap) {
        if (cloneMap.containsKey(node))
            return cloneMap.get(node);

        Node clone = new Node(node.val);
        cloneMap.put(node, clone);

        for (Node neigh : node.neighbors) {
            clone.neighbors.add(dfs(neigh, cloneMap));
        }

        return clone;

    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
