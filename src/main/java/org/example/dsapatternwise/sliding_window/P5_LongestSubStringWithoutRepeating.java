package org.example.dsapatternwise.sliding_window;

import java.util.HashMap;

public class P5_LongestSubStringWithoutRepeating {

    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     * <p>
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * <p>
     * <p>
     * Constraints:
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     *
     */

    public static void main(String[] args) {
        System.out.println(longesSubStrWORepeating("pwwkew"));
    }

    private static int longesSubStrWORepeating(String s) {

        int low = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        int size = s.length();
        if (size == 0) return 0;
        int result = Integer.MIN_VALUE;

        for (int high = 0; high < size; high++) {

            // get info from the window -> create frequency map
            hs.put(s.charAt(high), hs.getOrDefault(s.charAt(high), 0) + 1);

            // Three cases :
            // 1. hs.size == window size --> valid case
            // 2. hs.size < window size --> invalid case, increase low and re-calculate currLen
            // 3. hs.size > window size --> will never occur

            // invalid case
            int currLen = high - low + 1;
            while (low < high && hs.size() < currLen) {
                hs.put(s.charAt(low), hs.get(s.charAt(low)) - 1);
                if (hs.get(s.charAt(low)) == 0) hs.remove(s.charAt(low));
                low++;
                currLen = high - low + 1;
            }

            // valid case
            int length = high - low + 1;
            result = Math.max(result, length);
        }
        return result;
    }
}
