package org.example;

import lombok.val;
import org.apache.commons.lang.math.IntRange;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PPInternal_1 {

    private static int CHARACTER_RANGE= 256;
    public static void main(String[] args) {
        int a = args.length;

        PPInternal_1 ppInternal = new PPInternal_1();
//        q1Method("My name is anthony gonsalves");
//        q2Method(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 3);
//        q3Method();
//        q4Method(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
//        q5Method();
//        System.out.println(factorial(5));
//        System.out.println(isAnagram("ant", "tan"));
//        System.out.println(isPalindrome("9An8a."));
//        charFrequency();
//        q10Method();
//        ppInternal.evenOddPrinter();
//        removeItems();
//        frequencyOccurence("atlassian");
//        Double d1 = 0.0/0.0;
//        System.out.println(d1.isInfinite());
//        System.out.println(d1.isNaN() +" ");
    }

    //Q1 reverse the words in space separated string
    static void q1Method(String s){
        val split = s.split(" ");

        for (int i = split.length-1; i >= 0 ; --i) {
            System.out.print(split[i] + " ");
        }
    }

    // Q2 : Program to shift element to left 3 times in an array
    //    Input list[] = [0, 1, 2, 3, 4] , output = [3,4,5,1,2]
    //    D = 2
    static void q2Method(ArrayList<Integer> arr, Integer t){
        int size = arr.size();
        val tempArr = new ArrayList<Integer>();

        for (int i = 0; i < t; i++) {
            tempArr.add(arr.get(i));
        }
        arr.removeAll(tempArr);
        arr.addAll(tempArr);

        System.out.println(arr);
    }

    // Q3 : Integer arr - multiply by 3 and if even value show as output
    static void q3Method(){
        IntStream.rangeClosed(1,20)
                .map(i-> i*3)
                .filter(q -> q % 2 == 0)
                .forEach(r -> System.out.print(r + ", "));

    }

    //Q4 : integer array [3,5,4,6,2] &sum = 7, output pair is sum ex: [5,2],[4,3]
    static void q4Method(List<Integer> arr){
        Integer sum = 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Integer integer : arr) {
            if (map.containsKey(integer))
                result.add(new ArrayList<>(Arrays.asList(integer, map.get(integer))));
            else
                map.put((sum-integer), integer);
        }
        System.out.println(result);
    }

    //Q5 : find duplicate character and count from string
    static void q5Method(){
        String s = "Missisipi";
        Map<String, Long> collect = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.entrySet()
                .forEach(System.out::println);
    }

    //Q6 factorial with recursion
    static Integer factorial(Integer n){
        if (n==0)
            return 1;
        return n * factorial(n-1);
    }

    //Q7 : find the given two strings are anagrams or not without using collection framework like List, map etc.
    static Boolean isAnagram(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        int[] count = new int[CHARACTER_RANGE];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)] ++;
            count[str2.charAt(i)] --;
        }

        int sum = Arrays.stream(count).sum();
        return sum == 0;
    }

//    public static boolean isAnagramCounting(String string1, String string2) {
//
//    }

    // Q8: given a string, check if the string is palindrom (same when reversed), the string might have special characters/numbers in it-ignore those and
    //only consider the alphabates - example :  ",(9An8a.:" - it is a palindrom as alphabates Ana when reversed gives the same.
    public static boolean isPalindrome(String str){
        String collect = Arrays.stream(str.split(""))
                .filter(e -> e.matches("[A-Za-z]"))
                .map(String::toLowerCase)
                .collect(Collectors.joining(""));

        for (int i = 0; i < (collect.length()-1)/2; i++) {
            if (collect.charAt(i) != collect.charAt(collect.length()-1-i))
                return false;
        }
        return true;
    }

    // Q9: Program for Frequency of characters using hashmap.
    static void charFrequency(){
//
        Character ch = 'a';
        System.out.println(Character.isDigit(ch));
    }

    //Q10: Input => array [-12, 11, -13, -5, 6, -7, 5, -3, -6]
    //Output => {11, 6, 5,-12,-13,-5,-7,-3,-6}
    static void q10Method(){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-12, 11, -13, -5, 6, -7, 5, -3, -6));
        List<Integer> negative = arr.stream().filter(i -> i < 0).collect(Collectors.toList());

        arr.removeAll(negative);
        arr.addAll(negative);
        System.out.println(arr);

    }

    // Q11: print even odd number using 2 threads in sequential manner
    void evenOddPrinter(){

        AtomicInteger count = new AtomicInteger(0);
        int max = 20;

        Runnable evenPrinter = () -> {
          synchronized (this){
              while (count.get() < max){
                  if (count.get()%2 != 0){
                      try {
                          wait();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }
                  }
                  System.out.println("Even Number is :" + count.get());
                  count.getAndIncrement();
                  notify();
              }
          }
        };

        Runnable oddPrinter = () -> {
            synchronized (this){
                while (count.get() < max){
                    if (count.get()%2 == 0){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Odd Number is :" + count.get());
                    count.getAndIncrement();
                    notify();
                }
            }
        };

        Thread evenThread = new Thread(evenPrinter);
        Thread oddThread = new Thread(oddPrinter);

        evenThread.start();
        oddThread.start();

    }
    static boolean isEven(Integer a){
        if (a%2==0)
            return true;
        return false;
    }

    // "ACB-100-10001-lASD-20-4420Y-150" & list[10,20,30,50,100] = "ACB-10001-lASD-4420Y-150"
    static void removeItems(){
        String s1 = "ACB-100-10001-lASD-20-4420Y-150-50";
        List<Integer> numbers = Arrays.asList(10,20,30,50,100);
        List<String> sNumbers = numbers.stream().map(String::valueOf).collect(Collectors.toList());

        String result = Arrays.stream(s1.split("-"))
                .filter(i -> !sNumbers.contains(i))
                .collect(Collectors.joining("-"));
        System.out.println(result);
    }

    static void frequencyOccurence(String s){
        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }



}
