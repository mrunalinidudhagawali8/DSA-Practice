package com.leetcode;

public class Leetcode1342 {
    public int numberOfSteps(int num) {
        int c = 0;

        return count(num, c);
    }

    public static int count(int num, int c) {
        if (num == 0)
            return c;

        if (num % 2 != 0) {
            return count(num - 1, c + 1);
        } else {
            return count(num / 2, c + 1);
        }

    }
}
