package org.example.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    /*
    The mergeSort method recursively splits the array into halves until each subarray has one element.
    The merge method combines two sorted subarrays into a single sorted array:
    It uses Arrays.copyOfRange to create temporary left and right subarrays.
    It merges these by comparing elements and copying the smaller one back into the original array.
    Any remaining elements from either subarray are copied over.
     */

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random(1000);
        for (int i = 0; i <arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

//    private static void mergeSort(int[] arr, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            mergeSort(arr, left, mid);
//            mergeSort(arr, mid + 1, right);
//            merge(arr, left, mid, right);
//        }
//    }
//
//    private static void merge(int[] arr, int left, int mid, int right) {
//        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
//        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
//        int i = 0, j = 0, k = left;
//        while (i < leftArr.length && j < rightArr.length)
//            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
//        while (i < leftArr.length)
//            arr[k++] = leftArr[i++];
//        while (j < rightArr.length)
//            arr[k++] = rightArr[j++];
//    }
}
