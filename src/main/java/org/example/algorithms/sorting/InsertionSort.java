package org.example.algorithms.sorting;

public class InsertionSort {


    /*
    Insertion sort builds the sorted array one element at a time.
    It takes each element from the unsorted part and inserts it into its correct position in the
    sorted part by shifting larger elements to the right.
    This process repeats until the whole array is sorted. It works well for small or nearly sorted arrays.
     */

    public static void main(String[] args) {
        int[] sortedArr = insertionSort(new int[]{5, 1, 4, 2, 8});
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }

    }

    // 1,5,4,2,8 - 1st
    // 14528

    private static int[] insertionSort(int[] inputArr) {

        for (int i = 1; i < inputArr.length; i++) {
            int current = inputArr[i];
            int j = i - 1;
            while (j >= 0 && current < inputArr[j]){
                inputArr[j+1] = inputArr[j];
                j--;
            }
            inputArr[j+1] = current;
        }
        return inputArr;
    }
}
