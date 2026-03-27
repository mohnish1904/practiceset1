package org.example.dsapatternwise.sliding_window;

import java.util.*;

public class P6_LongestRepeatingCharSubString {

    /**
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
     * You can perform this operation at most k times.
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     * <p>
     * Example 1:
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     * Example 2:
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     * There may exists other ways to achieve this answer too.
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 105
     * s consists of only uppercase English letters.
     * 0 <= k <= s.length
     */

    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(maxRepeatingCharSubStr(str, 0));
    }

    private static int maxRepeatingCharSubStr(String s, int k) {
        int low = 0, high = 0;
        int result = Integer.MIN_VALUE;
        int size = s.length();
        int[] count = new int[256];

        for (; high < size; high++) {
            int length, maxCount, diff;

            count[s.charAt(high)]++;

            length = high - low + 1;
            maxCount = getMaxCount(count);
            diff = length - maxCount;

            // Three conditions:
            while (low < high && diff > k) {
                count[s.charAt(low)]--;
                low++;
                maxCount = getMaxCount(count);
                length = high - low + 1;
                diff = length - maxCount;
            }

            // Update the result, by finding max(result, map.values.sum).
            length = high - low + 1;
            result = Math.max(result, length);
        }

        return result;
    }

    private static int getMaxCount(int[] count) {
        int max = Integer.MIN_VALUE;
        for (int val : count) {
            if (max < val)
                max = val;
        }
        return max;
    }
}
