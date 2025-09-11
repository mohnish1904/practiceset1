package org.example.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5};
        System.out.println(removeDupsSortedArray(arr));
        System.out.println(removeDupsSortedArrayUsingSet(arr));
    }

    private static long removeDupsSortedArrayUsingSet(int[] arr) {
        return Arrays.stream(arr).distinct().count();

    }


    private static int removeDupsSortedArray(int[] arr) {

        if (arr.length == 0)
            return 0;

        int uniqueCounter = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i+1])
                uniqueCounter++;
        }

        return uniqueCounter;
    }

//    private static int removeDupsSortedArray(int[] arr) {
//        if (arr.length == 0)
//            return 0;
//
//        int uniqueCounter = 1;
//        for (int i = 0; i < arr.length-1; i++) {
//            if (arr[i] != arr[i+1]){
//                uniqueCounter++;
//            }
//        }
//        return uniqueCounter;
//    }



}
