package org.example.LeetCode;

public class climbStairs {

    public static void main(String[] args) {
        System.out.println(climbingStairs(10));
    }

    private static int climbingStairs(int i) {
        if (i ==0 || i==1)
            return 1;

        int prev = 1, curr = 1;

        for (int j = 2; j <= i; j++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
}
