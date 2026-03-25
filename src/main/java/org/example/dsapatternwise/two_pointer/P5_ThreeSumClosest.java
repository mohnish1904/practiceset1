package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;

public class P5_ThreeSumClosest {

    /**
     * Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
     * <p>
     * Return the sum of the three integers.
     * <p>
     * You may assume that each input would have exactly one solution.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Example 2:
     * <p>
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 3 <= nums.length <= 500
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     */

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 0));
    }

    private static int threeSumClosest(int[] nums, int target) {

        int size = nums.length;
        // sort the array
        Arrays.sort(nums);

        // create 2 vars, resultSum & maxDiff = MAX
        int maxDiff = Integer.MAX_VALUE;
        int resultSum = 0;

        // iterate for i and use two pointer to get the sum
        // if sum equals to target , return sum
        // if sum less than or greater than target, check maxDiff,
        // if maxDiff < currMaxDiff, update the result Sum

        for (int curr = 0; curr < size; curr++) {

            int left = curr + 1;
            int right = size - 1;

            while (left < right && curr != left && right != curr) {
                int sum = nums[curr] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                else {
                    if (maxDiff > Math.abs(target - sum)) {
                        maxDiff = Math.abs(target - sum);
                        resultSum = sum;
                    }

                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return resultSum;
    }
}
