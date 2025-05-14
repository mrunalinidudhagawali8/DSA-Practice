package com.leetcode;

import java.util.*;

public class Leetcode987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Pair prev = new Pair(root, 0, 0);

        Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<Pair> que = new LinkedList<>();

        que.offer(new Pair(root, 0, 0));
        prev = que.peek();



        while(!que.isEmpty()){
            Pair pair = que.poll();

            if(!map.containsKey(pair.col)){
               map.put(pair.col, new TreeMap<>());
            }

            map.get(pair.col).putIfAbsent(pair.row, new ArrayList<>());
            map.get(pair.col).get(pair.row).add(pair.node.val);


            if(pair.node.left!=null) que.offer(new Pair(pair.node.left, pair.col -1, pair.row+1));
            if(pair.node.right!=null) que.offer(new Pair(pair.node.right, pair.col +1, pair.row+1));
        }

        map.forEach((columns, tm)->{
            res.add(new ArrayList<>());
            tm.forEach((row, list )-> {
                Collections.sort(list);
                res.get(res.size()-1).addAll(list);
            });
        });

        return res;
    }
    static class Pair{
        TreeNode node;
        Integer col;
        Integer row;

        public Pair(TreeNode element1, Integer col, Integer row) {
            this.node = element1;
            this.col = col;
            this.row = row;

        }
    }

}
