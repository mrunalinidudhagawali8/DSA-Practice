package com.array;

import java.util.HashMap;
import java.util.Map;

public class Leetcode560 {
    public static void main(String[] args) {
        System.out.println( subarraySum(new int[]{1}, 0));
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> ps = new HashMap<>();

        int count = 0;
        ps.put(0, 1);//to map the case psum=k then ps[i]-k=0
        int psum = 0;

        for(int i=0;i<nums.length;i++)
        {
            psum += nums[i];

            if(ps.containsKey(psum-k))
            {
                count += ps.get(psum-k);
            }
            ps.put(psum, ps.getOrDefault(psum, 0)+1);
        }

        return count;
    }
}
