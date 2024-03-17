package com.selection;

public class FindSmallestElement {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 40, 5, 60, 20 };
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("The minimum element in the array is :: " + min);
	}

}
