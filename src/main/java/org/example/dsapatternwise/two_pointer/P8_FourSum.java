package org.example.dsapatternwise.two_pointer;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

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
     * <p>
     * -3,-1,0,2,4,5
     */

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int low = 0;
        int size = nums.length;
        Arrays.sort(nums);

        if (size < 4) return new ArrayList<>();

        if (size == 4) {
            long resultSum = Arrays.stream(nums).mapToLong(e->e).sum();
            if (resultSum != target) {
                return new ArrayList<>();
            } else {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
        }

        while (size > 4 && low < size) {
            int high = low + 1;
            while (high < size) {
                int left = high + 1;
                int right = size - 1;
                while (left < right) {
                    long sum = nums[low] + nums[left] + nums[right] + nums[high];
                    if (sum == target) {
                        result.add(List.of(nums[low], nums[left], nums[right], nums[high]));
                        left++;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                high++;
            }
            low++;
        }
        return new ArrayList<>(result);
    }


}
