package com.leetcode;

/**
 * Journal 21-Apr-2025 (Sliding Windo)
Problem | Pattern | Learning
LC 643 | Fixed Sliding Window | Max sum/avg in window
LC 209 | Variable Sliding Window | Shrinking window smartly
LC 424 | Variable + HashMap | Replace at most k to get same char
LC 1004 | Variable Sliding Window | Flip at most k zeros to 1
LC 76 | Brute Force | Window with all target chars
LC 239 | Brute Force | Max value in each window

 ## what challenged me today
 1. debugging corner cases >= or >
 2. there can be cases when you don't need a while loop inside for loop for var size window case
 3. in case of fix size window in sliding window - its better to initiatliase the first window in a separate loop and in subsequent loop to slide it slightly
 4. identified the best data structure that can be used
 5. Iterating the set

 ## Proud momnet
 I solved a lot of problems today among which max are medium level and few from hard with brute force atleast
 */

/**
 * Journal 22-Apr-2025
 *
 * Practised mostly Two Pointers (Practise for hard problems not done
 *
 Problem | Pattern | Learning
 LC 75 (Med)
 LC 26(Easy)

 ## what challenged me today / what best happened
 1. two pointers can be either expanding (left to right) or shrinking(inwards from end
 2. Learned Dutch Flag algorithm (LC 75), a classic example of three pointers and sorting the array in one loop
 3. Found that switch case is faster than if else statements as switch gets optimized during compilation
 4. found that primitive array elements like arr[i] cannot be initialized with null value

 What you need to focus in next few days:
 1. revision of previous topics
 2. notes of all the topics covered so far


 ## Proud momnet
 I solved a two pointers problem with my (own) Brute force approach that was already with minimum TC O(n)
 */























/**
 * Q1 : Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */

/**
 * Q2 : 13-04-2025
 * TwoSum : Blind#1
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 */

/**
 * Q3 : 13-04-2025
 * 560. Subarray Sym Equals K
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

/**
 * LeetCode121 :
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

/**
 * 53. Maximum Subarray
 * Comapnies Medium	Amazon, Google, Adobe
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */

/**
 * 918. Maximum Sum Circular Subarray
 *Companies - Medium	Google, Microsoft
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * Example 2:
 *
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * Example 3:
 *
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 */

/**
 * 152. Maximum Product Subarray
 * Companies - Medium	Bloomberg
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */

/**
 * 560. Subarray Sum Equals K
 * Facebook, Google
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

/**
 *
 713. Subarray Product Less Than K

 Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 Example 1:

 Input: nums = [10,5,2,6], k = 100
 Output: 8
 Explanation: The 8 subarrays that have product less than 100 are:
 [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 Example 2:

 Input: nums = [1,2,3], k = 0
 Output: 0


 Constraints:

 1 <= nums.length <= 3 * 104
 1 <= nums[i] <= 1000
 0 <= k <= 106
 */

/**
 * 724. Find Pivot Index
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 */