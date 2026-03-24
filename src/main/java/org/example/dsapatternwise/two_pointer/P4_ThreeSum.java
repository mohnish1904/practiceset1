package org.example.dsapatternwise.two_pointer;

import java.util.*;
import java.util.stream.Collectors;

public class P4_ThreeSum {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     *
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     *
     *
     * Constranums:
     *
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        // sort the array
        Arrays.sort(nums); // nlogn

        for (int currIdx = 0; currIdx < nums.length - 1; currIdx++) {

            if (currIdx !=0 && nums[currIdx]==nums[currIdx-1]) continue;
            if (nums[currIdx]>0) break;

            int leftIdx = currIdx+1;
            int rightIdx = nums.length-1;
            while(currIdx != leftIdx && leftIdx < rightIdx && currIdx != rightIdx){
                int sum = nums[currIdx] + nums[leftIdx] + nums[rightIdx];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[currIdx], nums[leftIdx], nums[rightIdx])));
                    do {
                        leftIdx++;
                    } while (leftIdx < rightIdx && nums[leftIdx-1] == nums[leftIdx]);

                    do {
                        rightIdx--;
                    } while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx+1]);

                } else if (sum > 0) {
                    rightIdx--;
                } else {
                    leftIdx++;
                }
            }

        }
        return new ArrayList<>(result);
    }
}
