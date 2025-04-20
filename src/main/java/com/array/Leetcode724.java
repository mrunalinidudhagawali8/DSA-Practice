package com.array;

public class Leetcode724 {
    public static void main(String[] args) {
        System.out.println(getPivotIndex(new int[]{1,7,3,6,5,6}));
    }

    private static int getPivotIndex(int[] arr) {
        int[] ps = new int[arr.length];

        if(arr.length==1) return 0;
        ps[0] = arr[0];

        for(int i=1;i<arr.length;i++)
        {
            ps[i] = ps[i-1]+arr[i];
        }

        for(int i=0;i<ps.length;i++)
        {
            for(int i=0;i<arr.length;i++)
            {
                int sl;
                if(i==0){
                    sl=0;
                }else{
                    sl = ps[i-1];
                }
                int sr = ps[ps.length-1]-ps[i];
                if (sl == sr) return i;

            }
        }

        return -1;
    }
}
