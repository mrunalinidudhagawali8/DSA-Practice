package com.array;

import org.springframework.util.StringUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {
        System.out.println(((int)'a' + "  " + (int)'A'));
        System.out.println(generateParenthesis(5));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        makeValidParenthesis(n, sb.append("(") , 1, 0 , res);
        return res;
    }
    private static void makeValidParenthesis(int n, StringBuilder sb, int open, int close, List<String> res) {
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            makeValidParenthesis(n, sb, open+1, close, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            makeValidParenthesis(n, sb, open, close+1, res);
            sb.deleteCharAt(sb.length()-1);
        }


    }
//    private static void makeValidParenthesis(int n, String str, int open, int close, List<String> res) {
//        if(str.length()==2*n){
//            res.add(str);
//
//            return;
//        }
//
//        if(open<n){
//
//            makeValidParenthesis(n, str+"(", open+1, close, res);
//        }
//        if(close<open){
//            makeValidParenthesis(n, str+")", open, close+1, res);
//        }
//        /**
//         * Douubt : not able to figure out why we didnt need to exlude the choice
//         *
//         * Anss : Using str+"(" or str+")" , string being mutable so everytime it creates a new string instance, also for large n this prcoess will create a lot of GC overhead,
//         * hence its better to use StringBuilder
//         */
//
//
//    }
}
