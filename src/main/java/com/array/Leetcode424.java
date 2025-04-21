package com.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode424 {

    public static void main(String[] args) {
//        System.out.println(characterReplacementbruteForce("ABBBA", 2));
        System.out.println(characterReplacement("ABBAB", 2));
    }

    private static int characterReplacement(String str, int k) {
        char[] ch = str.toCharArray();

        int start=0, end=0, maxFreqinWindow=0, maxLen=0;

        Map<Character, Integer> map = new HashMap<>();



        for(end=0;end<ch.length;end++)
        {
            map.put(ch[end], map.getOrDefault(ch[end], 1)+1);
            maxFreqinWindow = Math.max(maxFreqinWindow, map.get(ch[end]));

            if(((end-start+1) - maxFreqinWindow)>k)//window invalid hence move start pointer to right
            {
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);

        }

        return maxLen;
    }

    public static int characterReplacementbruteForce(String s, int k) {
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : ch) set.add(c);

        int maxLen = 0;

        for (Character target : set) {
            for (int i = 0; i < ch.length; i++) {
                int len = 0, flag = k;
                for (int j = i; j < ch.length; j++) {
                    if (ch[j] == target) {
                        len++;
                    } else if (flag > 0) {
                        len++;
                        flag--;
                    } else {
                        break;
                    }

                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

}
