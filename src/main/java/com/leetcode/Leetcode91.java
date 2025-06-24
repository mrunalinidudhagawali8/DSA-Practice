package com.leetcode;

import java.util.Arrays;

public class Leetcode91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1]; // dp[i] = ways to decode from i onward

        dp[n] = 1; // base case: empty string has one way

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1]; // take one digit
                if (i + 1 < n) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigit <= 26) {
                        dp[i] += dp[i + 2]; // take two digits
                    }
                }
            }
        }

        return dp[0]; // ways to decode full string
    }

}
