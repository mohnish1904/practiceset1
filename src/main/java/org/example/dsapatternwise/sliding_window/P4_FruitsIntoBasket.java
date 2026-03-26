package org.example.dsapatternwise.sliding_window;

import java.util.HashMap;

public class P4_FruitsIntoBasket {

    /**
     * You are visiting a farm that has a single row of fruit trees arranged from left to right.
     * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     *
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
     * The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick.

     * Example 1:
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     * Example 2:
     * Input: fruits = [0,1,2,2]
     * Output: 3
     * Explanation: We can pick from trees [1,2,2].
     * If we had started at the first tree, we would only pick from trees [0,1].
     * Example 3:
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     */

    public static void main(String[] args) {
        System.out.println(fruitsIntoBasket(new int[]{1,2,3,2,2}));
    }

    private static int fruitsIntoBasket(int[] nums) {

        // [1, 2, 3, 2 , 2]

        // initialize a hashmap
        HashMap<Integer, Integer> hs = new HashMap<>();

        // initialize pointers
        int low = 0;
        int result = 0;

        for (int high = 0; high < nums.length; high++) {
            // do operations with high
            hs.put(nums[high], hs.getOrDefault(nums[high], 0)+1);

            while (low < high && hs.size() > 2){
                hs.put(nums[low], hs.get(nums[low])-1);
                if (hs.get(nums[low]) == 0) hs.remove(nums[low]);
                low++;
            }
            int length = high - low + 1;
            result = Math.max(result, length);
        }
        return result;
    }
}
