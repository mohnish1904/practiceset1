package org.example.dsapatternwise.sliding_window;

public class P2_MinSizeSubArraySum {

    /**
     * Minimum size subarray sum
     * min. length of sub array whose sum >= target
     *
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     */

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 4};
        int target = 4;
        System.out.println(minSize(nums, target));
    }

    private static int minSize(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int high = 0, low = 0;
        int size = nums.length;

        while (high < size) {
            //hiring
            sum = sum + nums[high];

            // check if value is greater then target
            while (sum >= target) {
                result = Math.min(result, high - low + 1);

                //firing
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
