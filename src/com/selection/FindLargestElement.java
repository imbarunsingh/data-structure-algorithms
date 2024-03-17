package com.selection;

public class FindLargestElement {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 40, 5, 60, 20 };
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("The largest element in the array is :: " + max);
	}

}
