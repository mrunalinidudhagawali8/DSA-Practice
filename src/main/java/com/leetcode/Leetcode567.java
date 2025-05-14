package com.leetcode;

import java.util.Arrays;

public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        //make an freq array of s1 and s2
        int[] s1f = new int[26];
        int[] s2f = new int[26];

        int k = s1.length();
        if(s1.length()>s2.length()) return false;

        for(int i=0;i<k;i++)
        {
            s1f[s1.charAt(i)-'a']++;
            s2f[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(s1f, s2f)) return true;
        //use sliding window to check the frequency map

        for(int i=k;i<s2.length();i++)
        {
            s2f[s2.charAt(i)-'a']++;
            s2f[s2.charAt(i-k)-'a']--;

            if(Arrays.equals(s1f,s2f)) return true;
        }

        return false;
    }
}
