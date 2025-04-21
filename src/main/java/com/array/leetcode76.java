package com.array;

import java.util.HashMap;
import java.util.Map;

public class leetcode76
{
    public static void main(String[] args) {
        System.out.println(minWindowBrute("ADOBECODEBANC", "ABC"));
    }
    public static String minWindowBrute(String s, String t) {

        StringBuilder res = new StringBuilder("huh");

        //take out the hashmap of t
        Map<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> hm = new HashMap<>(map);
        char[] ch1 = t.toCharArray();
        char[] ch2 = s.toCharArray();

        if(s.length()<t.length())
        {
            return "";
        }

        for(int i=0;i<t.length();i++)
        {
            map.put(ch1[i], map.getOrDefault(ch1[i], 0)+1);
        }

        for(int i=0;i<s.length();i++)
        {

            hm = new HashMap<>(map);
            for(int j=i;j<s.length();j++)
            {
                if(hm.containsKey(ch2[j]))
                {
                    hm.put(ch2[j], hm.get(ch2[j])-1);
                    if(hm.get(ch2[j])==0) hm.remove(ch2[j]);
                }

                if(hm.isEmpty()){
                    res = new StringBuilder(s.substring(i,j+1));
                }
            }
        }

        return res.toString();
    }
}
