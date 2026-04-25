package org.example.dsapatternwise.binarysearch;

import java.util.Arrays;

public class P6_SearchInRotatedArr {
    /**
     * 33. Search in Rotated Sorted Array
     * Medium
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly left rotated at an
     * unknown index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
     * <p>
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * Example 1:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     * Input: nums = [1], target = 0
     * Output: -1
     * <p>
     * Constraints:
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * All values of nums are unique.
     * nums is an ascending array that is possibly rotated.
     * -104 <= target <= 104
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(searchInRotatedArr(nums, 0));
    }

    private static int searchInRotatedArr(int[] nums, int target) {
        // divide it into 2 parts
        // P2 : 4,5,6,7     P1 : 0,1,2 (elements gt and lt last)
        // if target < last ---> search in P1 else search in P2
        // use binary search
        int last = nums.length - 1;
        int low = 0;
        int high = nums.length - 1;
        int min = 0;

        // find the min value idx
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[last]) {
                low = mid + 1;
            } else {
                min = mid;
                high = mid - 1;
            }
        }

        if (nums[min]==target) return min;

        if (target < nums[min]){
            low = min;
            high = nums.length-1;
        } else {
            low = 0;
            high = min;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;
    }
}
