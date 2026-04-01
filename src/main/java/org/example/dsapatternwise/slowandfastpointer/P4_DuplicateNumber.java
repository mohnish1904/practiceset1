package org.example.dsapatternwise.slowandfastpointer;

public class P4_DuplicateNumber {

    /**
     287. Find the Duplicate Number
     Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     There is only one repeated number in nums, return this repeated number.
     You must solve the problem without modifying the array nums and using only constant extra space.

     Example 1:=
     Input: nums = [1,3,4,2,2]
     Output: 2
     Example 2:
     Input: nums = [3,1,3,4,2]
     Output: 3
     Example 3:
     Input: nums = [3,3,3,3,3]
     Output: 3

     Constraints:
     1 <= n <= 105
     nums.length == n + 1
     1 <= nums[i] <= n
     All the integers in nums appear only once except for precisely one integer which appears two or more times.

     Follow up:
     How can we prove that at least one duplicate number must exist in nums?
     Can you solve the problem in linear runtime complexity?
     */

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));

    }

    private static int findDuplicate(int[] nums) {
        // start from 0th index, treat it as head
        int slow = 0;
        int fast = 0;

        // 0 -> a[1] ->a[3] -> a[4] -> a[2] ->|
        //                             a[2] <-|

        // run slow and fast loop -> but keep it as true as we are sure there is a loop in this case
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (slow == fast) { // slow and fast meet
                slow = 0;
                while (slow != fast) { // find the start of starting point of cycle
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }

}
