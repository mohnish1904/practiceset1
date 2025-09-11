package org.example.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,1,2,6,4};
        System.out.println(checkPermutation(array1, array2)); // check sum and product
    }


    //Brute Force
    private static boolean checkPermutation(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;

        int sum1 = 0, sum2=0, prod1=1, prod2=1;

        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 =+ array2[i];

            prod1 *= array1[i];
            prod2 *= array2[i];
        }

        if (sum1 == sum2 && prod2==prod1)
            return true;
        return false;
    }

}
