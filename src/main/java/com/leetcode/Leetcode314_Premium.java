package com.leetcode;

import java.sql.Array;
import java.util.*;

public class Leetcode314_Premium {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair> que = new LinkedList<>();

        que.offer(new Pair(root, 0));

        while(!que.isEmpty())
        {
            Pair pair = que.poll();

            map.putIfAbsent(pair.col, new ArrayList<>());
            map.get(pair.col).add(pair.node.val);

            if(pair.node.left!=null) que.offer(new Pair(pair.node.left, pair.col-1));
            if(pair.node.right!=null) que.offer(new Pair(pair.node.right, pair.col+1));
        }

        map.forEach((key, value)->{
            res.add(value);
        });

        return res;

    }

    static class Pair{
        TreeNode node;
        Integer col;

        public Pair(TreeNode node , Integer col){
            this.node = node;
            this.col = col;
        }
    }
}
