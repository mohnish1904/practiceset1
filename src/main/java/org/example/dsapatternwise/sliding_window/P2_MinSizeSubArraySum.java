package org.example.dsapatternwise.sliding_window;

public class P2_MinSizeSubArraySum {

    /**
     * Minimum size subarray sum
     * min. length of sub array whose sum >= target
     */

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 4};
        int target = 4;
        System.out.println(minSize(nums, target));
    }

    private static int minSize(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int high = 0, low = 0;
        int size = nums.length;

        while (high < size) {
            //hiring
            sum = sum + nums[high];

            // check if value is greater then target
            while (sum >= target) {
                result = Math.min(result, high - low + 1);

                //firing
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
