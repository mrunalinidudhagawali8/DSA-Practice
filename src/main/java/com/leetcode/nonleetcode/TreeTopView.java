package com.leetcode.nonleetcode;

import java.util.*;

public class TreeTopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        System.out.println(topView(root));
    }

    private static List<Integer> topView(TreeNode root) {
        if(root==null) return null;

        Queue<Pair> que = new LinkedList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        List<Integer> lis = new ArrayList<>();

        que.offer(new Pair(0, root));

        while(!que.isEmpty()){
            Pair temp = que.poll();
            if(!hm.containsKey(temp.hrootdist)){
                hm.put(temp.hrootdist, temp.node.val);
            }

            if(temp.node.left!=null) que.offer(new Pair(temp.hrootdist-1, temp.node.left));
            if(temp.node.right!=null) que.offer(new Pair(temp.hrootdist+1, temp.node.right));
        }

        hm.forEach((hrootdist, val)->
                lis.add(val));

        return lis;
    }
    public static class Pair {
        int hrootdist;
        TreeNode node;

        public Pair(int hrootdist, TreeNode node) {
            this.hrootdist = hrootdist;
            this.node = node;
        }

        @Override
        public String toString() {
            return "(" + hrootdist + ", " + node + ")";
        }
    }


}
