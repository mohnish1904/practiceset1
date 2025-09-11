package org.example.recursion;

public class Easy {


    public static void main(String[] args) {

//        System.out.println(printSumNatNumbers(3));
//        printNumbers(5);
//        System.out.println(printFactorial(5));
//        printNFibonnaci(0,1,9);
        System.out.println(printxpown(2,8));


    }

    // Q. find x pow n
    private static int printxpown(int x, int n) {
        if (n==0)
            return 1;
        if (x==0)
            return 0;
        return x * printxpown(x, n-1);
    }

    // Q. find x pow n with log n stack
    private static int printxpownNlogn(int x, int n) {
        if (n==0)
            return 1;
        if (x==0)
            return 0;

        if (n%2==0)
            return printxpownNlogn(x, n/2) * printxpownNlogn(x, n/2);
        else
            return printxpownNlogn(x, n/2) * printxpownNlogn(x, n/2) * x;
    }

    // Q print fibonnaci
    private static void printNFibonnaci(int a, int b,int n) {
        if (n==0)
            return;
        System.out.println(a);
        printNFibonnaci(b,b+a, n-1);
    }

    // Q3. Print factorial
    private static int printFactorial(int n) {
        if (n==0) return 1;
        return n * printFactorial(n-1);
    }

    // Q1. Print sum of N natural numbers
    private static int printSumNatNumbers(int n) {
        if (n==0)
            return 0;
        n += printSumNatNumbers(n-1);
        return n;
    }

    // Q1. Another way
    //    n = n*(n+1)/2
    private static int printSumNatNumbers2(int n) {
        return n*(n+1)/2;
    }

    // Q2 . print n numbers
    private static void printNumbers(int n) {
        if (n==0)
            return;
        System.out.println(n);
        printNumbers(n-1);
    }




}
