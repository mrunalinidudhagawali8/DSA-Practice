package com.array;

public class Leetcode1004
{
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,0,1,1,1,1,1,0}, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int start=0, end=0;
        int maxlen=0, f1=0 ;

        for(end=0;end<nums.length;end++)
        {
            if(nums[end]==1) f1++;

            int currwindow = end-start+1;

            if((currwindow-f1)<=k){
                maxlen = Math.max(maxlen, currwindow);
            }else{
                if(nums[start]==1) f1--;
                start++;

            }
        }
        return maxlen;
    }
    public static int longestOnesBruteForce(int[] nums, int k) {
        int maxLen = 0;

        for(int i=0;i<nums.length;i++)
        {
            int len=0, temp=k;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]==1){
                    len++;
                }else{
                    if(temp>0)
                    {
                        len++;
                        temp--;
                    }else{
                        break;
                    }
                }

            }
            maxLen = Math.max(len, maxLen);

        }

        return maxLen;
    }
}
