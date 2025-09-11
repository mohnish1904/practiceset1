package org.example.algorithms.sorting;

public class BubbleSort {


    public static void main(String[] args) {
        int[] sortedArr = bubbleSort2(new int[]{5, 1, 4, 2, 8});
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }

    }

    /*
    Bubble sort works by repeatedly going through the list, comparing two neighboring numbers,
    and swapping them if they are in the wrong order. This process is repeated until the list is sorted.
    The biggest numbers "bubble up" to the end of the list with each pass.
     */

    private static int[] bubbleSort(int[] ints) {
        boolean swapped;
        int n = ints.length;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    // Swap ints[i] and ints[i + 1]
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    swapped = true;
                }
            }
            n--; // Reduce the range of the next pass
        } while (swapped);

        return ints;
    }

    private static int[] bubbleSort2(int[] ints){
        boolean swapped;
        int n = ints.length;

        do{
            swapped= false;
            for (int i = 1; i < n; i++) {
                if (ints[i-1] > ints[i]){
                    //swap i with i+1
                    int temp = ints[i-1];
                    ints[i-1] = ints[i];
                    ints[i] = temp;
                    swapped= true;
                }
            }
        } while (swapped);

        return ints;
    }


}
