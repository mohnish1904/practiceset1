package org.example.dsapatternwise.two_pointer;

import java.util.*;
import java.util.stream.Collectors;

public class P3_SquaresOfSortedArray {

    public static void main(String[] args) {
        /**
         * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
         *
         * Example 1:
         * Input: nums = [-4,-1,0,3,10]
         * Output: [0,1,9,16,100]
         * Explanation: After squaring, the array becomes [16,1,0,9,100].
         * After sorting, it becomes [0,1,9,16,100].
         * Example 2:
         * Input: nums = [-7,-3,2,3,11]
         * Output: [4,9,9,49,121]
         */

        int[] nums = new int[]{-4, -1, 0, 3, 10};
        sortSq(nums);
    }

    private static int[] sortSq(int[] nums) {

        // Using Streams
        //return Arrays.stream(nums).map(e->e*e).sorted().toArray();

        // Using arrays method
//        int[] result = new int[nums.length];
//        int idx = 0;
//        for(int num : nums){
//            result[idx] = num*num;
//            idx++;
//        }
//        Arrays.sort(result);
//        return result;


        // create 2 list - positive and negative
        // reverse the negative list
        // we will have 2 sorted arrays
        // merge 2 sorted arr using 2 pointers
        int[] result = new int[nums.length];
        int idx = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];

            if (leftSq > rightSq){
                result[idx] = leftSq;
                idx--;
                left++;
            } else {
                result[idx] = rightSq;
                idx--;
                right--;
            }
        }
        return result;
    }
}
