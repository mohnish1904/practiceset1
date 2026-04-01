package org.example.dsapatternwise.kadaneAlgo;

public class P3_MaxProductSubArray {

    /**
     152. Maximum Product Subarray
     Given an integer array nums, find a subarray that has the largest product, and return the product.
     The test cases are generated so that the answer will fit in a 32-bit integer.
     Note that the product of an array with a single element is the value of that element.

     Example 1:
     Input: nums = [2,3,-2,4]
     Output: 6
     Explanation: [2,3] has the largest product 6.
     Example 2:
     Input: nums = [-2,0,-1]
     Output: 0
     Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


     Constraints:
     1 <= nums.length <= 2 * 104
     -10 <= nums[i] <= 10
     The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
     */

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProductSubArr(arr));
    }

    private static int maxProductSubArr(int[] arr) {
        int result = arr[0];
        int maxProd = arr[0];
        int minProd = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int min = minProd * val;
            int max = maxProd * val;

            maxProd = Math.max(val, Math.max(min,max));
            minProd = Math.min(val, Math.min(min,max));

            result = Math.max(result, Math.max(maxProd,minProd));
        }

        return 0;
    }

}
