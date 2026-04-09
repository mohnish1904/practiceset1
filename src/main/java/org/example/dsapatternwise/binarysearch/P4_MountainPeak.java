package org.example.dsapatternwise.binarysearch;

public class P4_MountainPeak {

    /**
     * 852. Peak Index in a Mountain Array
     * Medium
     * You are given an integer mountain array arr of length n
     * where the values increase to a peak element and then decrease.
     * Return the index of the peak element.
     * Your task is to solve it in O(log(n)) time complexity.
     * <p>
     * Example 1:
     * Input: arr = [0,1,0]
     * Output: 1
     * Example 2:
     * Input: arr = [0,2,1,0]
     * Output: 1
     * Example 3:
     * Input: arr = [0,10,5,2]
     * Output: 1
     * <p>
     * Constraints:
     * 3 <= arr.length <= 105
     * 0 <= arr[i] <= 106
     * arr is guaranteed to be a mountain array.
     */

    public static void main(String[] args) {
        int[] arr = {18,29,38,59,98,100,99,98,90};
        System.out.println(peakIndex(arr));
    }

    private static int peakIndex(int[] arr) {

        // in this case if arr[i] < arr[i+1] is increasing then it means we are ascending
        // if arr[i] > arr[i+1], then we are descending
        // so the problem becomes monotonic
        // ascend , ascend, ascend, descend , descend, descend

        int low = 0, high = arr.length - 1;
        int peakIdx = -1;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[mid] < arr[mid + 1]) // ascend
                low = mid + 1;
            else {
                peakIdx = mid;
                high = mid - 1;
            }
        }
        return peakIdx;
    }
}
