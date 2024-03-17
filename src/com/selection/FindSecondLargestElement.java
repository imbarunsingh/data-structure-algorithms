package com.selection;

public class FindSecondLargestElement {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 40, 5, 60, 20, 55 };
		int max = arr[0];

		// First find the max element
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int maxSecond = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxSecond && arr[i] < max) {
				maxSecond = arr[i];
			}
		}
		System.out.println("The second largest element in the array is :: " + maxSecond);
	}

}
