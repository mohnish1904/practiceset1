package org.example.dsapatternwise.sliding_window;

public class P7_MinWindowSubString {

    /**
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that every character in t (including duplicates)
     * is included in the window. If there is no such substring, return the empty string "".
     * <p>
     * The testcases will be generated such that the answer is unique.
     * <p>
     * Example 1:
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * <p>
     * Constraints:
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
     */

    public static void main(String[] args) {
        System.out.println("result-> " + minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        // create char frequency map of t -> freqT -- done

        // for s
        // use sliding window to find min substring
        // create frequency map freqS
        // valid case : freqS should have frequency of the char greater than or equal to
        //              the frequency of that char in freqT
        // increase the window in invalid case
        // decrease the window in valid case, note the result


        int[] freqT = new int[256];
        int[] freqS = new int[256];

        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i)]++;
            if (freqT[t.charAt(i)] > 0)
                System.out.println(t.charAt(i));
        }

        int low = 0;
        String result = "";
        int len = 0;
        int minLen = Integer.MAX_VALUE;

        for (int high = 0; high < s.length(); high++) {

            freqS[s.charAt(high)]++;

            while (low <= high && isCondTrue(freqS, freqT)) {
                len = high - low + 1;
                if (minLen > len) {
                    System.out.println(s.substring(low, high+1));
                    result = s.substring(low, high+1);
                    minLen = len;
                }
                freqS[s.charAt(low)]--;
                low++;
            }
        }
        return result;
    }

    private static boolean isCondTrue(int[] freqS, int[] freqT) {
        for (int i = 0; i < freqT.length; i++) {
            if (freqT[i] > 0 && freqS[i] < freqT[i]) // A
                return false;
        }
        return true;
    }
}
