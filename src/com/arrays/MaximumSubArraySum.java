package com.arrays;

//Kadanes Algorithm
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int arr[] = {5,4,-1,7,8};	//23 is max

        //int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6 is max

        System.out.println("Maximum Sum-> Brute :: " + maximumSubArrayBruteForce(arr));

        System.out.println("Maximum Sum -> Optimal :: " + maximumSubArrayOptimal(arr));
    }

    public static int maximumSubArrayBruteForce(int arr[]) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int maximumSubArrayOptimal(int arr[]) {
        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
