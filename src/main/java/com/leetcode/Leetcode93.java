package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, sb, s, res);
        return res;
    }

    public static void backtrack(int start, int segmentCount, StringBuilder sb, String s, List<String> res) {
        if(start==s.length() && segmentCount==4){
            res.add(sb.toString());
            return;
        }

        for(int end=start;end<s.length();end++)
        {
            String substr = s.substring(start, end+1);
            if(isValid(substr)){
                int lenBefore = sb.length();
                sb.append(substr);
                if(end!=s.length()-1) sb.append('.');

                backtrack(end+1, segmentCount+1,  sb, s, res);
                sb.setLength(lenBefore);

            }
        }
    }

    private static boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        try {
            Integer temp = Integer.parseInt(s);
            if (temp >= 0 && temp <= 255) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
