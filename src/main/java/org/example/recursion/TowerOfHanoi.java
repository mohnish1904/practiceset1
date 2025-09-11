package org.example.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 5; // number of disks
        towerOfHanoi(n, "A", "B", "C");
    }

    private static void towerOfHanoi(int n, String source, String helper, String dest) {
        if (n==1){
            System.out.println("Move disk 1 from" +source+ " to "+dest);
            return;
        }
        towerOfHanoi(n-1, source, dest, helper);
        System.out.println("Move disk " + n +" from " + source +" to "+ dest);
        towerOfHanoi(n-1, helper, source, dest);
    }
}
