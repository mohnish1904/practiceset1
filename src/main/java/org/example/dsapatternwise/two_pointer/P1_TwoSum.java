package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    /**
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
     * find two numbers such that they add up to a specific target number.
     * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     * Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2]of length 2.
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     * Your solution must use only constant extra space.
     *
     * Example 1:
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     * Example 2:
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     * Example 3:
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2Pointer(new int[]{2, 7, 11, 15}, 9)));
    }

    // Using hashmap
    public static int[] twoSumHashMap(int[] numbers, int target) {
        Map<Integer, Integer> hs = new HashMap<>();
        int idx = 0;

        for (Integer curr : numbers){
            idx ++;
            int compliment = target - curr ;

            if (hs.containsKey(curr))
                return new int[]{hs.get(curr), idx};
            else
                hs.put(compliment, idx);
        }
        return new int[]{};
    }

    // Using hashmap
    public static int[] twoSum2Pointer(int[] numbers, int target) {

        // its an array
        // its an sorted array so index vlaue can be provided
        // need to find pair
        int size = numbers.length;
        int left = 0, right = size-1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (target == sum)
                return new int[]{left+1, right+1};
            else if (target < sum)
                right--;
            else left++;
        }
        return new int[]{};
    }
}
