package org.example.LeetCode.strings;

import java.util.HashMap;

public class LongestSubString {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(bruteforce(str));
        System.out.println(slidingWindowPrac(str));
    }

    private static int slidingWindow(String str) {

        HashMap<String, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        for(; right < str.length(); right++){
            // if map contains the char, update the index value of char
            if (map.containsKey(String.valueOf(str.charAt(right)))){
                map.put(String.valueOf(str.charAt(right)), map.get(String.valueOf(str.charAt(right))+1));
            } else {
                // if it does not contain, then put the value in the map with index
                // increment the maxlength
                map.put(String.valueOf(str.charAt(right)), map.get(String.valueOf(str.charAt(right))));
                maxLength += 1;
            }
        }
        return maxLength;
    }

    private static int bruteforce(String str) {
        int maxlength = 0;
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                if (sb.indexOf(String.valueOf(str.charAt(j))) != -1)
                    break;
                sb.append(str.charAt(j));
                maxlength = Math.max(maxlength, sb.length());
            }
        }
        return maxlength;
    }

    public static int slidingWindowPrac(String str){
        int left = 0, right = 0 , maxLength=0;
        HashMap<Character, Integer> hs = new HashMap<>();
        for (; right < str.length(); right++) {
            // if hashmap contains the char, update the left idx to charIdx+1
            // if not then put the char in map and increase maxlength by 1

            if (hs.containsKey(str.charAt(right))){
                hs.put(str.charAt(right), hs.get(str.charAt(right))+1);
            } else {
                hs.put(str.charAt(right), right);
                maxLength += 1;
            }
        }
        return maxLength;
    }

}
