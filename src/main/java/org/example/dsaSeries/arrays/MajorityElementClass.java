package org.example.dsaSeries.arrays;

import java.util.HashMap;


public class MajorityElementClass {

    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: 3
     *
     * Example 2:
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     * Constraints:
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     * The input is generated such that a majority element will exist in the array.
     */

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int count = nums.length/2;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int result = 0;
        for (int i : nums){
            if (hs.containsKey(i)){
                hs.put(i, hs.get(i)+1);
                if (hs.get(i) > count)
                    result = i;
            } else {
                hs.put(i, 1);
            }
        }
        return result;
    }

}
