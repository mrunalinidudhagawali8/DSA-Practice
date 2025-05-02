package com.array;

import java.util.ArrayList;
import java.util.List;

public class Leetcode784 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("a1b2");
        List<String> permuts = new ArrayList<>();
        backtrack(0, permuts, sb);
        System.out.println(permuts);
    }

    public static void backtrack(int start, List<String> permuts, StringBuilder str) {
        if(start==str.length()){
            permuts.add(str.toString()); return;
        }

        char c = str.charAt(start);

        if (Character.isLetter(c)) {
            // Lowercase version
            backtrack(start + 1, permuts, str);

            str.setCharAt(start, oppositeCaseConvertUtil(c));
            backtrack(start+ 1, permuts, str);
            str.setCharAt(start, c); // undo
        } else {
            // Just move forward for digits/symbols
            backtrack(start + 1, permuts, str);

        }

    }


private static char oppositeCaseConvertUtil(char c){

    if(Character.isUpperCase(c)){
        return Character.toLowerCase(c);
    }else {
        return  Character.toUpperCase(c);
    }


}
}
