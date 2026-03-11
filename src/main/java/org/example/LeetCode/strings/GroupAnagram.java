package org.example.LeetCode.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagram {


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams1(strs);
        lists.forEach(System.out::println);
    }

    private static void groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        Arrays.stream(strs).
                forEach(current -> {
                    String sortedStr = Arrays.stream(current.split(""))
                            .sorted().collect(Collectors.joining());
                    if (!hashMap.containsKey(sortedStr))
                        hashMap.put(sortedStr, new ArrayList<>());
                    hashMap.get(sortedStr).add(current);
                });
        System.out.println(hashMap.values());

//        for (String str : strs){
//            String sortedStr = Arrays.stream(str.split(""))
//            .sorted().reduce("", (a, b) -> a + b);
//
//            if (!hashMap.containsKey(sortedStr))
//                hashMap.put(sortedStr, new ArrayList<>());
//
//            hashMap.get(sortedStr).add(str);
//        }
//        System.out.println(hashMap.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            String sortedStr = Arrays.stream(str.split("")).sorted().collect(Collectors.joining(""));

            if (map.containsKey(sortedStr)) {
                List<String> list = map.get(sortedStr);
                list.add(str);
                map.put(sortedStr, list);
            } else {
                map.put(sortedStr, new ArrayList<>(List.of(str)));
            }
        }
        List<List<String>> result = new ArrayList<>();
        map.forEach((key, value) -> result.add(value));
        return result;
    }

}
