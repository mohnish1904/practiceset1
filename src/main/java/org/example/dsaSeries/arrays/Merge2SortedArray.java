package org.example.dsaSeries.arrays;

import java.util.Arrays;

public class Merge2SortedArray {

    /**
     *
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * Example 2:
     * <p>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * Explanation: The arrays we are merging are [1] and [].
     * The result of the merge is [1].
     * Example 3:
     * <p>
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * Explanation: The arrays we are merging are [] and [1].
     * The result of the merge is [1].
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     * <p>
     * <p>
     * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;

        merge(nums1, nums1Size, nums2, nums2Size);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = m - n - 1;
        int ptr2 = n - 1;
        int idx = m - 1;

        while (ptr1 >= 0 && ptr2 >= 0 && idx >= 0) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[idx] = nums1[ptr1];
                idx--;
                ptr1--;
            } else {
                nums1[idx] = nums2[ptr2];
                idx--;
                ptr2--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }


}
