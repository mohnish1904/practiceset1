package org.example.dsapatternwise.kadaneAlgo;


public class P4_MaxSumSubArrWOneDelete {

    /**
     * 1186. Maximum Subarray Sum with One Deletion
     * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements)
     * with at most one element deletion. In other words, you want to choose a subarray and optionally
     * delete one element from it so that there is still at least one element left and the sum of the
     * remaining elements is maximum possible.
     * Note that the subarray needs to be non-empty after deleting one element.
     * <p>
     * Example 1:
     * Input: arr = [1,-2,0,3]
     * Output: 4
     * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
     * Example 2:
     * Input: arr = [1,-2,-2,3]
     * Output: 3
     * Explanation: We just choose [3] and it's the maximum sum.
     * Example 3:
     * Input: arr = [-1,-1,-1,-1]
     * Output: -1
     * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
     * <p>
     * Constraints:
     * 1 <= arr.length <= 105
     * -104 <= arr[i] <= 104
     */

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println(maxSumSubArrW1Del(arr));
    }

    private static int maxSumSubArrW1Del(int[] arr) {
        int result = arr[0];
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            // For no delete : take max val from current a[i] or add a[i] + prevNoDelete
            noDelete = Math.max(arr[i], prevNoDelete + arr[i]);

            // For One delete
            // option 1: add current val to prev 1 delete ->  a[i] + prevOneDelete
            // option 2: one delete val without current val -> prevNoDelete
            int val = prevOneDelete == Integer.MIN_VALUE ? arr[i] : prevOneDelete + arr[i];

            oneDelete = Math.max(val, prevNoDelete);

            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        return result;
    }


}
