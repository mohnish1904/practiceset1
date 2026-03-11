package org.example.LeetCode;

import java.util.Arrays;

public class BestScore {

//    top 2 scores from a given list

    public static void main(String[] args) {
        int[] scores = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        System.out.println(Arrays.toString(bestScore1(scores)));
    }

    private static int[] bestScore(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = 0;

        for (int score : scores){
            if (first < score){
                second = first;
                first = score;
            } else if (score > second && score < first) {
                second = score;
            }
        }
        return new int[]{first, second};
    }

    private static int[] bestScore1(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = 0;

        for (int score : scores){
            if (score > first){
                second = first;
                first = score;
            } else if (score > second && score < first) {
                second = score;
            }
        }
        return new int[]{first,second};
    }


}
