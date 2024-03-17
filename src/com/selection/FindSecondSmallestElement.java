package com.selection;

public class FindSecondSmallestElement {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 40, 5, 60, 20, 55 };
		int min = arr[0];

		// First find the max element
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int minSecond = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minSecond && arr[i] < min) {
				minSecond = arr[i];
			}
		}
		System.out.println("The second smallest element in the array is :: " + minSecond);
	}

}
