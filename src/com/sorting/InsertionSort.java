package com.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int a[] = { 12, 8, 3, 11, 7 };
		// 8,12 j= 1
		int n = a.length, temp;

		for (int i = 1; i < n; i++) {
			temp = a[i]; // first element in the unsorted part
			int j = i - 1; // last element in the sorted part

			while (j >= 0 && a[j] > temp) { 
				a[j + 1] = a[j]; // Shift the element by one index right if it is greater
				j--;
			}
			a[j + 1] = temp; // basically the 0th index
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
