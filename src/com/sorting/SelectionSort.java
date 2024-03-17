package com.sorting;

/*Time Complexity(worst Case) : O(n*n)
Space Complexity : O(n)*/
public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = { 12, 8, 3, 11, 7 };
		int n = arr.length, min;

		for (int i = 0; i < n - 1; i++) { // n-1 pass for n elements
			min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
