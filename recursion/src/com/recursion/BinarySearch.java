package com.recursion;

public class BinarySearch {

	public static void main(String[] args) {

		int array[] = { 10, 20, 50, 80, 88, 99 };
		int elementFoundAtIndex = binarySearch(array, 88, 0, array.length - 1);

		if (elementFoundAtIndex == -1) {
			System.out.println("The element is not present in the array::");
			return;
		}
		System.out.println("The element is found in the array at index :: " + elementFoundAtIndex);
	}

	private static int binarySearch(int[] array, int elementToBeSearched, int startIndex, int endIndex) {

		int midIndex = (startIndex + endIndex) / 2;
		if (array[midIndex] == elementToBeSearched) {
			return midIndex;
		} else {
			if (elementToBeSearched < array[midIndex]) {
				endIndex = midIndex - 1;
			} else if (elementToBeSearched > array[midIndex]) {
				startIndex = midIndex + 1;
			}
			return binarySearch(array, elementToBeSearched, startIndex, endIndex);
		}

	}

}
