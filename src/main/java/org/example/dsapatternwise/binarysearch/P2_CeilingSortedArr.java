package org.example.dsapatternwise.binarysearch;

public class P2_CeilingSortedArr {

    /**
     * Ceil in a Sorted Array
     * Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest
     * element in arr[] that is greater than or equal to x. This element is called the ceil of x.
     * If such an element does not exist, return -1.
     * Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.
     * <p>
     * Examples
     * <p>
     * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
     * Output: 2
     * Explanation: Smallest number greater than 5 is 8, whose index is 2.
     * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 20
     * Output: -1
     * Explanation: No element greater than 20 is found. So output is -1.
     * Input: arr[] = [1, 1, 2, 8, 10, 11, 12, 19], x = 0
     * Output: 0
     * Explanation: Smallest number greater than 0 is 1, whose indices are 0 and 1. The index of the first occurrence is 0.
     * Constraints:
     * 1 ≤ arr.size() ≤ 106
     * 1 ≤ arr[i] ≤ 106
     * 0 ≤ x ≤ arr[n-1]
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(ceilingSortedArr(nums, 5));
    }

    private static int ceilingSortedArr(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        if (nums[high] < target)
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                result = mid;
                high = mid-1;
            } else
                low = mid+1;
        }
        return result;
    }


}
