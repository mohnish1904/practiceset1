package org.example.algorithms.sorting;

public class SelectionSort {

    /*
    Selection sort works by repeatedly finding the smallest element from the
    unsorted part of the array and moving it to the beginning
     */

    public static void main(String[] args) {
        int[] sortedArr = selectionSort(new int[]{5, 1, 4, 2, 8});
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
    }

    private static int[] selectionSort(int[] ints) {

        int len = ints.length;

        for (int i = 0; i < len-1; i++) {
            int minIdx = i;

            for (int j = i+1; j < len; j++) {
                if (ints[j] < ints[minIdx])
                    minIdx = j;
            }
            // swap ith value with miniIdx value
            int temp = ints[i];
            ints[i] = ints[minIdx];
            ints[minIdx] = temp;
        }
        return ints;
    }
}
