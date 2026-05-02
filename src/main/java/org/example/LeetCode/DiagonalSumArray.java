package org.example.LeetCode;

public class DiagonalSumArray {

    public static void main(String[] args) {
        int[][] myArray2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        diagonalSum(myArray2D);
        System.out.println(climbStairs(10));
    }

    private static void diagonalSum(int[][] myArray2D) {
        int sum = 0;
        int size = myArray2D.length - 1;
        while (size >= 0) {
            sum += myArray2D[size][size];
            size--;
        }
        System.out.println(sum);
    }


    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

}
