package org.example.dsapatternwise.two_pointer;

public class P9_BackspaceStringCompare {

    /**
     * 844. Backspace String Compare
     * Given two strings s and t, return true if they are equal when both are typed into
     * empty text editors. '#' means a backspace character.
     * Note that after backspacing an empty text, the text will continue empty.
     * <p>
     * Example 1:
     * Input: s = "ab#c", t = "ad#c"
     * Output: true
     * Explanation: Both s and t become "ac".
     * Example 2:
     * Input: s = "ab##", t = "c#d#"
     * Output: true
     * Explanation: Both s and t become "".
     * Example 3:
     * Input: s = "a#c", t = "b"
     * Output: false
     * Explanation: s becomes "c" while t becomes "b".
     * <p>
     * Constraints:
     * 1 <= s.length, t.length <= 200
     * s and t only contain lowercase letters and '#' characters.
     */

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        s = getBckSpacedStr(s);
        t = getBckSpacedStr(t);

        return s.equalsIgnoreCase(t);
    }

    private static String getBckSpacedStr(String s) {
        if (!s.contains("#"))
            return s;
        if (1 == s.length())
            return "";

        int left = 0;
        int right = 0;

        while (left<=right && right < s.length()){
            if (s.charAt(right) == '#'){
                s = s.substring(left,right-1) + s.substring(right+1);
                right = 0;
            }
            right++;
        }
        return s;
    }
}
