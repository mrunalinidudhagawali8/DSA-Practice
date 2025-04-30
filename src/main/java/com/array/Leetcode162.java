package com.array;

public class Leetcode162 {
    //    more optimal : when start=end , we are at peak
//    public int findPeakElement(int[] arr) {
//        int start = 0, end = arr.length - 1;
//
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//
//            if (arr[mid] > arr[mid + 1]) {
//                end = mid; // Peak is on the left including mid
//            } else {
//                start = mid + 1; // Peak is on the right excluding mid
//            }
//        }
//
//        return start; // or end (both are same here)
//    }
    public int findPeakElement(int[] arr) {
        int start = 0, end = arr.length - 1;

        if (end == 0) return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int left = (mid == 0) ? Integer.MIN_VALUE : arr[mid - 1];
            int right = (mid == arr.length - 1) ? Integer.MIN_VALUE : arr[mid + 1];

            if (left < arr[mid] && arr[mid] > right) return mid;
            else {
                if (arr[mid] < right) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return start;
    }

}
