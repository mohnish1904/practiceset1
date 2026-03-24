package org.example.dsapatternwise.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Constraints:
     *
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0,1,2,-1,-4}));
    }

    private static List<List<Integer>> threeSum(int[] ints) {
        int idx = 0;
        List<List<Integer>> result = new ArrayList<>();

        // sort the array
        Arrays.sort(ints); // nlogn

        for (int currIdx = 0; currIdx < ints.length - 3; currIdx++) {

            int leftIdx = currIdx+1;
            int rightIdx = ints.length-1;
            while(currIdx != leftIdx && currIdx != rightIdx && leftIdx != rightIdx){
                int sum = ints[currIdx] + ints[leftIdx] + ints[rightIdx];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(ints[currIdx], ints[leftIdx], ints[rightIdx])));
                    break;
                } else if (sum > 0) {
                    rightIdx--;
                } else {
                    leftIdx++;
                }
            }
        }
        return  result;
    }
}
