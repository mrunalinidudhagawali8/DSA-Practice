package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Blind1 {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                /**
                 * This statement is the main twst :
                 * if it's a case of two identical nums eg. [3,3] with a target of 6
                 * so first iteration will not contain the first 3, then it will put the first 3
                 * with value as 0 and in the second iteration it will find the value
                 * and then no need to put the second three in solution
                 * the hashmap entries will just have one entry <3, 0>
                 */
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }

                map.put(nums[i], i);
            }
            return new int[]{};
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));           // [0, 1]
        }

}
