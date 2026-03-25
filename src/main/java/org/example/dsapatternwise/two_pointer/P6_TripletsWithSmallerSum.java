package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;

public class P6_TripletsWithSmallerSum {
    /**
     * Given an array arr[] of distinct integers of size n and a value sum,
     * the task is to find the count of triplets (i, j, k),
     * having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.
     * <p>
     * Examples :
     * <p>
     * Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
     * Output:  2
     * Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3).
     * Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
     * Output: 4
     * Explanation: Below are triplets with sum less than 12 (1, 3, 4), (5, 1, 3), (1, 3, 7) and (5, 1, 4).
     * Constraints:
     * 3 ≤ N ≤ 103
     * -103 ≤ arr[i] ≤ 103
     */

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3, 4, 7};
        System.out.println(tripletsWithSmallerSum(nums, nums.length, 12));
    }

    private static int tripletsWithSmallerSum(int[] nums, int size, int target) {
        int result = 0;

        // sort the array
        Arrays.sort(nums);

        // if sum >= target, right --
        // if sum < target, result = result + (right-left)
        // --> all the values between left and right will also be less, we can do result ++ as well

        for (int curr = 0; curr < size; curr++) {

            int left = curr + 1;
            int right = size - 1;

            while (left < right && left != curr && right != curr) {
                int sum = nums[curr] + nums[left] + nums[right];

                if (sum >= target)
                    right--;
                else {
                    result = result + (right - left);
                    left++;
                }
            }
        }

        return result;
    }
}
