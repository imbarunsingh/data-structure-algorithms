package com.arrays;

import java.util.ArrayList;
import java.util.List;


//Refer sumit mallick video
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 6, 10};
        List<Integer> result = new ArrayList<>();

        //productOfArrayBruteForce(arr, result);

        productOfArrayOptimal(arr, result);

        System.out.println(result);
    }

    public static void productOfArrayBruteForce(int arr[], List<Integer> result) {

        for (int i = 0; i < arr.length; i++) {

            int product = 1;

            for (int j = 0; j < arr.length; j++) {

                if (i == j) {
                    continue;
                }
                product = product * arr[j];
            }
            result.add(product);
        }
    }

    public static void productOfArrayOptimal(int arr[], List<Integer> result) {
        int length = arr.length;

        int prefixArr[] = new int[length];
        int suffixArr[] = new int[length];

        //prefix array initialization
        prefixArr[0] = 1;
        for (int i = 1; i < length; i++) {
            prefixArr[i] = prefixArr[i - 1] * arr[i - 1];
        }

        //suffix array initialization
        suffixArr[length - 1] = 1; //last index
        for (int i = length - 2; i >= 0; i--) {
            suffixArr[i] = suffixArr[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            result.add(prefixArr[i] * suffixArr[i]);
        }
    }

}
