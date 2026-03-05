package org.example.dsaSeries.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class MissingAndRepeatedValues {

    /**
     * You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. 
     * Each integer appears exactly once except a which appears twice and b which is missing. 
     * The task is to find the repeating and missing numbers a and b.
     * Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.
     */

    public static void main(String[] args) {
        int[][] arr = new int[][]{{9,1,7}, {8,9,2}, {3,4,6}};
        System.out.println("Using hashmap method:");
        Arrays.stream(findRepeatedAndMissingElement(arr)).forEach(System.out::println);

        System.out.println("Using optimized arithmetic method:");
        Arrays.stream(findRepeatedAndMissingElementOptimized(arr)).forEach(System.out::println);

        System.out.println("Using XOR-based method:");
        Arrays.stream(findRepeatedAndMissingElementXor(arr)).forEach(System.out::println);

        System.out.println("Using boolean-array method:");
        Arrays.stream(findRepeatedAndMissingElementBoolean(arr)).forEach(System.out::println);

    }

    private static int[] findRepeatedAndMissingElement(int[][] arr) {
        int repeated = 0;
        int missing = 0;
        int maxVal = arr.length * arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (map.containsKey(arr[i][j])){
                    map.put(arr[i][j], map.get(arr[i][j])+1);
                } else {
                    map.put(arr[i][j], 1);
                }
            }
        }

        missing = IntStream.rangeClosed(1, maxVal).sum() - map.keySet().stream().reduce(0, Integer::sum);
        repeated = map.entrySet().stream().filter(e->e.getValue() == 2).findFirst().map(Map.Entry::getKey).get();
        return new int[]{repeated, missing};
    }

    /**
     * Optimized method: uses sum and sum-of-squares to derive repeated and missing values.
     * Time: O(n^2) to scan the grid. Space: O(1) extra. Uses long to avoid overflow.
     */
    private static int[] findRepeatedAndMissingElementOptimized(int[][] arr) {
        int n = arr.length;
        int N = n * n;

        long totalSum = (long) N * (N + 1) / 2;
        long totalSq = (long) N * (N + 1) * (2L * N + 1) / 6;

        long sum = 0L;
        long sumSq = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = arr[i][j];
                sum += v;
                sumSq += (long) v * v;
            }
        }

        long D = sum - totalSum; // repeated - missing
        if (D == 0) throw new IllegalArgumentException("Invalid input: no difference found between sums");

        long diffSq = sumSq - totalSq; // repeated^2 - missing^2 = D * (repeated + missing)
        long sumRepPlusMiss = diffSq / D;

        long repeated = (D + sumRepPlusMiss) / 2;
        long missing = sumRepPlusMiss - repeated;

        return new int[]{(int) repeated, (int) missing};
    }

    /**
     * XOR-based O(N) time, O(1) space method. Works because xorAll = missing ^ repeated.
     */
    private static int[] findRepeatedAndMissingElementXor(int[][] arr) {
        int n = arr.length;
        int N = n * n;

        int xor = 0;
        for (int i = 1; i <= N; i++) xor ^= i; // xor 1..N
        for (int i = 0; i < n; i++) { // xor all elements in grid
            for (int j = 0; j < n; j++) {
                xor ^= arr[i][j];
            }
        }

        int setBit = xor & -xor; // rightmost set bit

        int x = 0, y = 0; // will hold the two distinct values
        for (int i = 1; i <= N; i++) {
            if ((i & setBit) != 0) x ^= i; else y ^= i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = arr[i][j];
                if ((v & setBit) != 0) x ^= v; else y ^= v;
            }
        }

        int candidate1 = x, candidate2 = y;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == candidate1) count1++;
            }
        }
        if (count1 == 2) {
            return new int[]{candidate1, candidate2};
        } else {
            return new int[]{candidate2, candidate1};
        }
    }

    /**
     * Simple fast method using a boolean seen array. Time: O(N), Space: O(N) where N = n*n.
     * Lower overhead than HashMap and is straightforward.
     */
    private static int[] findRepeatedAndMissingElementBoolean(int[][] arr) {
        int n = arr.length;
        int N = n * n;
        boolean[] seen = new boolean[N + 1];
        int repeated = -1;
        for (int[] row : arr) {
            for (int v : row) {
                if (seen[v]) repeated = v;
                else seen[v] = true;
            }
        }
        int missing = -1;
        for (int i = 1; i <= N; i++) {
            if (!seen[i]) { missing = i; break; }
        }
        return new int[]{repeated, missing};
    }
}
