package com.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left=0;
        Set<Character> hs = new HashSet<>();


        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);
            while(hs.contains(c) ){
                hs.remove(s.charAt(left));
                left++;
            }hs.add(c);
            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen;
    }


    public static int lengthOfLongestSubstringBrute(String s) {
        int maxLen = 0;
        Map<Character, Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            int len = 0;
            for(int j=i;j<s.length();j++)
            {
                char c = s.charAt(j);
                if(!hm.containsKey(c) || hm.get(c)==0){
                    len++;
                    maxLen = Math.max(len, maxLen);
                    hm.put(c, hm.getOrDefault(c, 0)+1);
                }else{
                    hm.put(c, hm.get(c)-1);
                    len=0;
                }
            }
            hm.clear();
        }

        return maxLen;
    }
}
