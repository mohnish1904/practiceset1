package org.example.dsapatternwise.sliding_window;

public class P1_MaxSumSubArrayOfSizeK {

    /**
     *Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
     *
     * Note: A subarray is a contiguous part of any given array.
     *
     * Examples:
     *
     * Input: arr[] = [100, 200, 300, 400], k = 2
     * Output: 700
     * Explanation: arr2 + arr3 = 700, which is maximum.
     */
    public static void main(String[] args) {
        int[] newArr = new int[]{100, 200, 300, 400, 500};
        System.out.println(maxSum(newArr, 3));
    }

    private static int maxSum(int[] nums, int k) {

        int n = nums.length;
        int low = 0, high = k - 1;
        int sum = 0;
        int result = Integer.MIN_VALUE;

        // iterate for first k elements to get sum
        for (int i = low; i <= high; i++) {
            sum = sum + nums[i];
        }

        // slide the window and sum for k , better to subtract prev and add next in the sum
        while (high < n) {
            result = Math.max(sum, result);

            if (high + 1 >= n) break;

            sum = sum - nums[low];
            low++;
            high++;
            sum = sum + nums[high];
        }


        return result;


    }
}
