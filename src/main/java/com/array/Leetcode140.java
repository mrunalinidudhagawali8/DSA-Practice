package com.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String wordDict[] = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> res = wordBreak(s, List.of(wordDict));
        System.out.println(res);

    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDicSet  = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        backtrack(0, new StringBuilder(), res, s, wordDicSet);
        return res;

    }

    private static void backtrack(int start, StringBuilder cand, List<String> res, String s, Set<String> wordDic) {
        if(start==s.length()){
            res.add(cand.toString());
            return;
        }

        for(int end=start ;end<s.length();end++){
            String substr = s.substring(start, end+1);
            if(wordDic.contains(substr)){
                int lenBefore = cand.length();//track length before appeding
                if(end!=s.length()-1){
                    cand.append(substr).append(" ");
                }else{
                    cand.append((substr));
                }

                backtrack(end+1, cand, res, s, wordDic);
                char lastChar = cand.toString().charAt(cand.length()-1);
                System.out.println("cand : " + cand.toString()+ " Last char here : " + lastChar);

                cand.setLength(lenBefore);
            }
        }
    }
}
