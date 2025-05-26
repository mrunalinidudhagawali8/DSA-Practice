package com.recursion;

public class RecursionBasix2 {
    //Print name 5 times
    public static void main(String[] args) {
        String name = "Mru";

        int n = 65;

        printName(name, n);
    }

    private static void printName(String str, int n){
        if(n==0) return;

        System.out.println(str);
        printName(str, n-1);
    }
}
