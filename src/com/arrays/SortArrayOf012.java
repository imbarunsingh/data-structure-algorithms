package com.arrays;

import java.util.Arrays;

public class SortArrayOf012 {

    public static void main(String[] args) {

        int arr[] = {1, 0, 2, 1, 2, 1, 2, 0};

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(mid, high, arr);
                high--;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
