package com.searching;

//Time Complexity : O(nlogn) : divide and conquer
public class BinarySearch {
	public static void main(String[] args) {

		int array[] = { 10, 20, 50, 80, 88, 99 };
		int elementFoundAtIndex = binarySearch(array, 88);

		if (elementFoundAtIndex == -1) {
			System.out.println("The element is not present in the array::");
			return;
		}
		System.out.println("The element is found in the array at index :: " + elementFoundAtIndex);
	}

	private static int binarySearch(int array[], int searchElement) {
		int elementFoundAtIndex = -1;

		int startIndex = 0;
		int endIndex = array.length - 1;

		while (startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			if (searchElement == array[midIndex]) {
				elementFoundAtIndex = midIndex;
				break;
			} else if (searchElement < array[midIndex]) {
				endIndex = midIndex - 1;
			} else {
				startIndex = midIndex + 1;
			}
		}
		return elementFoundAtIndex;
	}
}