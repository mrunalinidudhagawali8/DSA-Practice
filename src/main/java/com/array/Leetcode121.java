package com.array;

public class Leetcode121 {
    public static void main(String[] args) {
        System.out.println( maxProfit(new int[]{7,6,4,3,1}));
    }
    public static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0;i<prices.length;i++)
        {
            //profit
            if(lowest<prices[i])
            {
                profit = Math.max(prices[i]-lowest, profit);
            }else
            {
                lowest = Math.min(lowest, prices[i]);
            }
        }

        return profit;
    }
}
