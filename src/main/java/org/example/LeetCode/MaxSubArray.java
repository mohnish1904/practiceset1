package org.example.LeetCode;

public class MaxSubArray {


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayMath(arr));
        System.out.println(maxSubArray1(arr));
    }

    private static int maxSubArray(int[] arr) {
        int maxSum = 0 , currSum = 0;
        for (int val : arr){
            currSum += val;

            if (maxSum < currSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum=0;
        }
        return maxSum;
    }

    private static int maxSubArrayMath(int[] arr) {
        int maxSum = arr[0], currentSum = arr[0];

        for(int i =0 ; i < arr.length ; i++){
           currentSum = Math.max(arr[i], currentSum+arr[i]);
           maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private static int maxSubArray1(int[] arr) {

        int maxSum=0,currSum =0;
        for (int val : arr){
            currSum += val;

            if (currSum > maxSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }





}
