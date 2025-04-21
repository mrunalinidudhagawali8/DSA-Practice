package com.array;

public class leetcode643 {
    public static void main(String[] args) {
//        System.out.println(findMaxAverageBrute(new int[]{5}, 1));

        System.out.println(findMaxAverage(new int[]{5}, 1));
    }
    public static double findMaxAverage(int[] nums, int k) {

        int maxSum;
        int sum = 0, temp=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        maxSum = sum;
        for(int i=k;i<nums.length;i++)
        {
            sum += nums[i]-nums[k-i];

            maxSum = Math.max(maxSum, sum);

        }

        return (double)maxSum/k;
    }
    public static double findMaxAverageBrute(int[] nums, int k) {

    double maxAvg = Double.NEGATIVE_INFINITY;
     for(int i=0;i<=nums.length-k;i++)
     {
         int sum=0;
         for(int j=i;j<=(i+k-1);j++)
         {
                 sum+=nums[j];
         }
         maxAvg = Math.max(maxAvg, (double) sum/k);
     }

     return maxAvg;
    }
}
