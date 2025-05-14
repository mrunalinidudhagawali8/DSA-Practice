package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
           int size = q.size();

           List<Integer> lvl = new ArrayList<>();

           for(int i=0;i<size;i++)
           {
               TreeNode node = q.poll();
               lvl.add(node.val);

               if(node.left!=null) q.offer(node.left);
               if(node.right!=null) q.offer(node.right);
           }

           res.add(lvl);
        }



    }
}
