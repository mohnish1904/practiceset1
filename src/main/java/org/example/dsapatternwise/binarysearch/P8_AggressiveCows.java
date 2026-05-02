package org.example.dsapatternwise.binarysearch;

/**
 * Aggressive Cows
 * You are given an array with unique elements of stalls[], which denote the positions of stalls.
 * You are also given an integer k which denotes the number of aggressive cows.
 * The task is to assign stalls to k cows such that the minimum distance between any two of them
 * is the maximum possible.
 * <p>
 * Examples:
 * <p>
 * Input: stalls[] = [1, 2, 4, 8, 9], k = 3
 * Output: 3
 * Explanation: The first cow can be placed at stalls[0],
 * the second cow can be placed at stalls[2] and
 * the third cow can be placed at stalls[3].
 * The minimum distance between cows in this case is 3, which is the largest among all possible ways.
 * Input: stalls[] = [10, 1, 2, 7, 5], k = 3
 * Output: 4
 * Explanation: The first cow can be placed at stalls[0],
 * the second cow can be placed at stalls[1] and
 * the third cow can be placed at stalls[4].
 * The minimum distance between cows in this case is 4, which is the largest among all possible ways.
 * Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
 * Output: 1
 * Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance between any two cows is as large as possible.
 * The minimum distance between cows in this case is 1, which is the largest among all possible ways.
 * <p>
 * Constraints:
 * 2 ≤ stalls.size() ≤ 106
 * 0 ≤ stalls[i] ≤ 108
 * 2 ≤ k ≤ stalls.size()
 */

public class P8_AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = new int[]{1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(aggressiveCows(stalls, k));
    }

    private static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;

        int low = 0;
        int high = stalls[n - 1] - stalls[0];
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int mid) {
        int cowCount = 1;
        int cowPos = stalls[0];

        for (int i = 0; i < stalls.length; i++) {
            int dist = stalls[i] - cowPos;
            if (dist < mid) continue;
            cowCount++;
            cowPos = stalls[i];
        }
        return cowCount >= k;
    }
}
