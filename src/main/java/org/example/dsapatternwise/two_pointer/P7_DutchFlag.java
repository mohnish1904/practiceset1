package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;

public class P7_DutchFlag {
    /**
     * Given an array nums with n objects colored red, white, or blue,
     * sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * You must solve this problem without using the library's sort function.
     * <p>
     * Example 1:
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * <p>
     * Constraints:
     * n == nums.length
     * 1 <= n <= 300
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dutchflag(new int[]{2, 1, 2, 2, 0, 0, 1, 1, 2, 0, 1})));
    }

    private static int[] dutchflag(int[] nums) {

        int low = 0; // red
        int mid = 0; // white
        int high = nums.length - 1; // blue

        while (mid <= high) {
            // 0
            if (nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (1 == nums[mid]) {
                swap(nums, mid, low);
                mid++;
            } else if (2 == nums[mid]) {
                swap(nums, mid, high);
                high--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int mid, int low) {
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
    }
}
