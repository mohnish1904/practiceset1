package org.example.LeetCode;

import java.util.Arrays;

public class Merge2SortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;

        System.out.println(Arrays.toString(merge(nums1, nums1Size, nums2, nums2Size)));

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Ptr = 0;
        int num2Ptr = 0;

        int [] result = new int[m+n];
        int idx = 0;

        while(num1Ptr < m && num2Ptr < n && idx < (m+n)){
            if (nums1[num1Ptr] < nums2[num2Ptr]){
                result[idx] = nums1[num1Ptr];
                idx++;
                num1Ptr++;
            } else if (nums1[num1Ptr] >= nums2[num2Ptr]) {
                result[idx] = nums2[num2Ptr];
                idx++;
                num2Ptr++;
            }
        }

        while(num1Ptr < m && idx < (m+n)){
            result[idx] = nums1[num1Ptr];
            num1Ptr++;
            idx++;
        }

        while(num2Ptr < n && idx < (m+n)){
            result[idx] = nums2[num2Ptr];
            num2Ptr++;
            idx++;
        }

        return result;
    }
}
