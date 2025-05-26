package com.leetcode;

import java.util.*;

public class practise {
    public static void main(String[] args) {

//        System.out.println(sumOfNNumber(3));
//        System.out.println(factorial(4));
//
//        int[] arr = new int[]{1,2,3,4};
//        reverse(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(Arrays.stream(arr).mapToObj(i -> i).toArray()));

        //is Palindrome check
        String str= "aabdbla";
        System.out.println(isPalindrome(str, 0));
    }

    private static int sumOfNNumber(int n) {

        if(n<1){
            return 0;
        }

        return n+sumOfNNumber(n-1);
    }

    private static int factorial(int n){
        if(n==1) return 1;

        return n*factorial(n-1);
    }


    private static void reverse(int[] arr, int left, int right) {
        if (left > right) return;

        //swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);
    }

    private static boolean isPalindrome(String str, int i){
        int n = str.length();
        if(i>=(n/2)) return true;

        if(str.charAt(i)!=str.charAt(n-i-1)) return false;

        return isPalindrome(str, i+1);
    }

}
