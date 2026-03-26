package org.example.dsapatternwise.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P8_FourSum {
    /**
     * Given an array nums of n integers, return an array of all the unique quadruplets
     * [nums[a], nums[b], nums[c], nums[d]] such that:
     * <p>
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * <p>
     * Example 1:
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     * Constraints:
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int low = 0;
        int high = nums.length - 1;

        Arrays.sort(nums);
        while (low < high) {
            int left = low + 1;
            int right = high - 1;
            while (left < right && left < high && right > low) {
                int sum = nums[low] + nums[left] + nums[right] + nums[high];
                if (sum == target) {
                    result.add(List.of(nums[low], nums[left], nums[right], nums[high]));
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            low++;
            high--;
        }
        return result;
    }
}
