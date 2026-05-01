package org.example.LeetCode.strings;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        System.out.println(longestPalindromicSubs("cbababcdf"));
    }

    private static int longestPalindrome(String str) {
        int left = 0, right = 0, maxLength = 0;
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            left = right = i;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                if (maxLength < ((right - left) + 1))
                    maxLength = (right - left) + 1;
                left--;
                right++;
            }
        }
        return maxLength;
    }

    private static int longestPalindromicSubs(String str) {

        int left = 0, right = 0, maxLen = 0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            left = i;
            right = i;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLen){
                    maxLen = len;
                    result = str.substring(left, right+1);
                }
                left --;
                right ++;
            }
        }
        System.out.println(result);
        return maxLen;
    }
}
