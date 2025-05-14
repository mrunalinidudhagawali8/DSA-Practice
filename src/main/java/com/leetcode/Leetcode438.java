package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
//        int targetsum=0;
//        String p = "abc";
//        for(int i=0;i<p.length();i++)
//        {
//            targetsum+=(int)(p.charAt(i));
//            System.out.println(targetsum);
//        }

//        System.out.println("Lowercase ASCII values:");
//        for (char c = 'a'; c <= 'z'; c++) {
//            sum += (int)c;
//            System.out.println(c + ": " + (int) c + " sum="+sum);
//        }
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> lis = new ArrayList<>();
       int k = p.length();

       int[] sf = new int[26]; //at time of this initialization, the array would be arr = [0,0,0,0,0....0]
       int[] pf = new int[26];

       if(s.length()<p.length()) return lis;

       for(int i=0;i<k;i++)
       {
           pf[p.charAt(i)-'a']++;
           sf[s.charAt(i)-'a']++;
       }
       if(Arrays.equals(sf, pf)) lis.add(0);

       for(int i=k;i<s.length();i++)
       {
           sf[s.charAt(i)-'a']++;
           sf[s.charAt(i-k)-'a']--;

           if(Arrays.equals(sf, pf)){
               lis.add(i-k+1);
           }

       }

       return lis;
    }
}
