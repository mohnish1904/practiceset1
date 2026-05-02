package org.example.dsapatternwise.binarysearch;

public class P6_SearchInRotatedArr_OneShot {
    /**
     * 33. Search in Rotated Sorted Array II
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
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedArr(nums, 0));
    }

    private static int searchInRotatedArr(int[] nums, int target) {

        // we need to find in which part the target lies in
        // then handle both part sperately
        int left = 0;
        int size = nums.length - 1;
        int right = size;
        if(nums.length == 0) return -1;

        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        // part 1 : nums[0] - highest Val
        if (target > nums[size]) {
            while (left <= right) {
                int mid = (left + right) / 2;

                if (target == nums[mid]) return mid;

                else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    // also 2 conditions
                    // guess gt a[size]
                    if (nums[mid] > nums[size]) {
                        left = mid + 1;
                    }
                    // guess lt a[size]
                    else
                        right = right - 1;
                }
            }
        }
        // part 2 : highestVal - nums[n]
        else {
            while (left <= right) {

                int mid = (left + right) / 2;
                if (target == nums[mid]) return mid;

                if (target > nums[mid])
                    left = left + 1;
                else if (nums[mid] > target){
                    if (nums[mid] < nums[size])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
        }

        return -1;
    }
}
