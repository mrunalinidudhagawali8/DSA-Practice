package com.leetcode;

import java.util.*;

public class Leetcode863 {
    Map<Integer, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createPreOrderMap(root, null);

        //do BFS to monitor levels
        return findDistKNodes(root, target, k);
    }

    private List<Integer> findDistKNodes(TreeNode root, TreeNode target, int k) {
        List<Integer> lis = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int dist = 0;

        if (root == null)
            return lis;

        que.offer(target);
        visited.add(target.val);

        while (!que.isEmpty()) {

            int size = que.size();
            if (dist == k)
                break;

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                TreeNode par = parentMap.get(curr.val);

                List<TreeNode> neighbors = Arrays.asList(curr.left, curr.right, par);

                for (TreeNode neighbour : neighbors) {
                    if (neighbour != null && !visited.contains(neighbour.val)) {
                        que.offer(neighbour);
                        visited.add(neighbour.val);
                    }

                }
            }

            dist++;
        }

        while (!que.isEmpty()) {
            lis.add(que.poll().val);
        }

        return lis;

    }

    private void createPreOrderMap(TreeNode node, TreeNode parent) {

        if (node == null)
            return;

        parentMap.put(node.val, parent);
        createPreOrderMap(node.left, node);
        createPreOrderMap(node.right, node);

    }
}
