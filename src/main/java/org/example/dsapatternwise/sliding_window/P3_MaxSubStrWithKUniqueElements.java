package org.example.dsapatternwise.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class P3_MaxSubStrWithKUniqueElements {

    /**
     * You are given a string s consisting only lowercase alphabets and an integer k.
     * Your task is to find the length of the longest substring that contains exactly k distinct characters.
     * <p>
     * Note : If no such substring exists, return -1.
     * Examples:
     * Input: s = "aabacbebebe", k = 3
     * Output: 7
     * Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
     */

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        int result = maxSubStr(s, k);
        System.out.println(result);
    }

    private static int maxSubStr(String s, int k) {
        int size = s.length();
        int result = -1;
        int low = 0, high = 0;
        HashMap<Character, Integer> hs = new HashMap<>();

        for (high = 0; high < size; high++) {

            // take info from window
            hs.put(s.charAt(high), hs.getOrDefault(s.charAt(high), 0) + 1);

            // till the info true
            while (hs.size() > k && low < high) {
                hs.put(s.charAt(low), hs.get(s.charAt(low)) - 1);
                if (hs.get(s.charAt(low)) == 0) hs.remove(s.charAt(low));
                low++;
            }

            if (hs.size() == k) {
                int length = high - low + 1;
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
