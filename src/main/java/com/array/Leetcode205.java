package com.array;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {

        int len = s.length();// tlen = t.length();
        Map<Character, Character> hm = new HashMap<>();

        if(len!=t.length()) return false;

        for(int i=0;i<len;i++)
        {
            if(hm.containsValue(t.charAt(i)) && !hm.containsKey(s.charAt(i))) return false;
            if(!hm.containsKey(s.charAt(i)))  hm.put(s.charAt(i), t.charAt(i));
            else if(hm.get(s.charAt(i))!=t.charAt(i) ) return false;

        }

        return true;

    }
}
