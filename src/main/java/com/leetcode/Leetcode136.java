package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sinfleNum = Integer.MIN_VALUE;
        for(int num : nums){
            if(hm.containsKey(num)){
                hm.remove(num);
            }else{
                hm.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            sinfleNum = entry.getKey();
        }

        return sinfleNum;
    }
}
