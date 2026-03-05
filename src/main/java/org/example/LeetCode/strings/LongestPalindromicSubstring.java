package org.example.LeetCode.strings;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbababcdf"));
    }

    private static int longestPalindrome(String str) {
        int left = 0, right=0, maxLength=0;
        String res="";

        for (int i = 0; i < str.length(); i++) {
            left = right = i;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
                if (maxLength < ((right - left) + 1))
                    maxLength = (right - left) + 1;
                left--;
                right++;
            }
        }
        return maxLength;
    }
}
