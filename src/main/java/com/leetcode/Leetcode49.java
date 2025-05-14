package com.leetcode;

import java.util.*;

public class Leetcode49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"ate", "tea", "bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String ss = new String(ch);

            hm.computeIfAbsent(ss, k->new ArrayList<>()).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}
