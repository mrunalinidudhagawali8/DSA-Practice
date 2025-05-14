package com.leetcode;

import java.util.*;

public class Leetcode290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {

        if(pattern.length()!=s.split(" ").length) return false;

        String[] words = s.split(" ");
        Map<Character, String> hm = new HashMap<>();
        Set<String> set = new HashSet<>();

        //iterate pattern chars and then map it to
        for(int i=0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!hm.containsKey(c)) {
                hm.put(c, words[i]);
                if( set.contains(words[i])) return false;
                else set.add(words[i]);
            } else if (!Objects.equals(hm.get(c), words[i])) return false;
            }


        return true;
    }
}
