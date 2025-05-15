package com.leetcode;

import java.util.*;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new TreeMap<>(Collections.reverseOrder());


        List<Integer> res = new ArrayList<>();


        for (int num : nums) {
            map1.putIfAbsent(num, 0);
            map1.put(num, map1.get(num) + 1);
        }

        map1.forEach((key, value)->{
            List<Integer> lis = map2.getOrDefault(value, new ArrayList<>());
            lis.add(key);
            map2.put(value, lis);
        });

        for(Map.Entry<Integer, List<Integer>> entry : map2.entrySet()){
            if(res.size()<k){
                List<Integer> tempLis =  entry.getValue();
                int i=0;
                while(i<tempLis.size() && res.size()<=k){
                    res.add(tempLis.get(i));
                    i++;
                }
            }else{
                break;
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
