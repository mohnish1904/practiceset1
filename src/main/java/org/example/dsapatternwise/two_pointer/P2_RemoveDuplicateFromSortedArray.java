package org.example.dsapatternwise.two_pointer;

import java.util.Arrays;

public class P2_RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDups(new int[]{1, 1, 1, 2, 2, 2, 3, 3})));
    }

    public static int[] removeDups(int[] arr){

        // sorted array
        // remove duplicates

        int low = 0;
        int high = 1;
        int uniqueElements = 1;

        while(high < arr.length){
            if (arr[high] != arr[high-1]){
                uniqueElements++;
                arr[low+1] = arr[high];
                low++;
            }
            high++;
        }
        System.out.println("Unique elements : "+uniqueElements);
        return arr;
    }
}
