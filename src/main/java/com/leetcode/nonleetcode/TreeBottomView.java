package com.leetcode.nonleetcode;

import java.util.*;

public class TreeBottomView {
    public static class Pair{
        int hrootDist;
        TreeNode node;

        public Pair(int hrootDist, TreeNode node) {
            this.hrootDist = hrootDist;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        System.out.println(bottomView(root));
    }

    private static List<Integer> bottomView(TreeNode root) {

        if(root==null) return null;

        Queue<Pair> que = new LinkedList<>();

        ArrayList<Integer> lis = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        que.offer(new Pair(0, root));

        while(!que.isEmpty())
        {
            Pair pair = que.poll();

            map.put(pair.hrootDist, pair.node.val);

            if(pair.node.left!=null) que.offer(new Pair(pair.hrootDist-1, pair.node.left));
            if(pair.node.right!=null) que.offer(new Pair(pair.hrootDist+1, pair.node.right));
        }


        map.forEach((hrootdist, val)->
                lis.add(val));

        return lis;
    }

}
