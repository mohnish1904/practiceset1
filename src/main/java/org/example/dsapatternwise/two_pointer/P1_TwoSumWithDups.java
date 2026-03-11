package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1_TwoSumWithDups {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2Pointer(new int[]{2, 2, 2, 7, 7, 11, 11, 11, 15, 15}, 9)));
    }

    // Using 2 pointer
    // array is sorted
    public static int[] twoSum2Pointer(int[] numbers, int target) {

        // its a array
        // its a sorted array so index vlaue can be provided
        // need to find pair
        int size = numbers.length;
        int l = 0, r = size - 1;

        while (l < r) {

            int sum = numbers[l] + numbers[r];
            if (sum == target)
                return new int[]{l, r};
            else if (sum > target) {
                do {
                    r--;
                } while (numbers[r - 1] == numbers[r]);
            } else {
                do {
                    l++;
                } while (numbers[l + 1] == numbers[l]);
            }
        }
        return new int[]{};
    }
}
