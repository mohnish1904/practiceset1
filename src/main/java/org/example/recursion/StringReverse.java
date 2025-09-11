package org.example.recursion;

public class StringReverse {

    public static void main(String[] args) {

        String s = "SomeVeryBigString";

        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse());

        reverseByRecursion(s, s.length()-1);
    }

    private static void reverseByRecursion(String s,int n) {
        if (n==0){
            System.out.print(s.charAt(n));
        } else {
            System.out.print(s.charAt(n));
            reverseByRecursion(s, n-1);
        }
    }
}
