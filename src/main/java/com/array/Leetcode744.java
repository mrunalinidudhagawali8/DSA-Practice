package com.array;

public class Leetcode744 {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'f'));
//        char aa = 'b';
//        aa = (char) (aa+1);
//        System.out.println(aa);
    }
    public static char nextGreatestLetter(char[] arr, char target) {
        int l=0, r = arr.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(arr[mid]==target){
                if(mid==(arr.length-1)) return arr[0];
                else l=mid+1;
            }
            else if(arr[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        if(l<arr.length) return arr[l];
        else return arr[0];
    }
}
