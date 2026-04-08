package org.example.dsapatternwise.binarysearch;

import java.util.Arrays;

public class P3_FirstAndLastIndexOfTarget {

    /**
     34. Find First and Last Position of Element in Sorted Array

     Given an array of integers nums sorted in non-decreasing order, find the starting
     and ending position of a given target value.

     If target is not found in the array, return [-1, -1].
     You must write an algorithm with O(log n) runtime complexity.

     Example 1:
     Input: nums = [5,7,7,8,8,10], target = 8
     Output: [3,4]
     Example 2:
     Input: nums = [5,7,7,8,8,10], target = 6
     Output: [-1,-1]
     Example 3:
     Input: nums = [], target = 0
     Output: [-1,-1]

     Constraints:
     0 <= nums.length <= 105
     -109 <= nums[i] <= 109
     nums is a non-decreasing array.
     -109 <= target <= 109
     */

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(firstAndLastPos(nums, 8)));
    }

    private static int[] firstAndLastPos(int[] nums, int target) {

        int low = 0, high = nums.length-1;
        int start = -1, end = -1;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] < target){
                low = mid+1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } if (nums[mid] == target) {
                start = mid;
                high = mid - 1;
            }
        }

        low = 0 ;
        high = nums.length-1;
        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] < target){
                low = mid+1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } if (nums[mid] == target) {
                end = mid;
                low = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}

