package org.example.dsapatternwise.binarysearch;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * Medium
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of
 * bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all
 * of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * <p>
 * Constraints:
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

public class P7_KokoEatingBanana {

    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        System.out.println(kokoEatingBanana(piles, h));
    }

    private static int kokoEatingBanana(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canKokoEat(piles, h, mid)){
                result = mid;
                high = mid-1;
            } else
                low = mid+1;
        }
        return result;
    }

    private static boolean canKokoEat(int[] piles, int h, int mid) {
        int timetaken = 0;

        for (int pile : piles){
            timetaken += pile/mid;
            if (pile%mid != 0) timetaken++;
        }
        return timetaken <= h;
    }
}
